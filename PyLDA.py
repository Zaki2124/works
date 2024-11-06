# LDA
import pandas as pd
import MeCab
import re
from sklearn.feature_extraction.text import CountVectorizer
from gensim.corpora.dictionary import Dictionary
from gensim.models import LdaModel
from tqdm import tqdm
import numpy as np
import csv

# PyLDAvis
import pyLDAvis
import pyLDAvis.gensim_models as gensimvis
from gensim.corpora.dictionary import Dictionary
from gensim.models import LdaModel



# データ読み込み
df = pd.read_csv("J17-SE.csv", encoding='shift-jis',index_col=0).reset_index()       # 読み込みファイル選択
print(df.head(100))

# df全体に対してmecab_tokenizerを適用し、形態素解析を行なったリストを返す関数
def make_docs(df,column_number):
    docs=[]
    print(df)
    print('---')
    for i in range(len(df)):
        print(i, column_number)
        text = df.iloc[i, column_number]
        docs.append(mecab_tokenizer(text))
    print(docs)
    return docs

# Nelogdによるトーカナイザー(リストで返す関数・名詞のみ)
def mecab_tokenizer(text):
    m = MeCab.Tagger('-d /usr/lib/x86_64-linux-gnu/mecab/dic/mecab-ipadic-neologd')
    m.parse('')
    l = []
    node = m.parseToNode(text)
    while node:
        if (node.surface):
            if (node.feature.split(',')[0] == "名詞" and node.feature.split(',')[1] != "数"):
                l.append(node.surface)
        node = node.next
    return l

# 形態素解析の実行
syllabus = make_docs(df,0)

    #辞書の作成
dictionary = Dictionary(syllabus)

# LdaModelが読み込めるBoW形式に変換
corpus = [dictionary.doc2bow(text) for text in syllabus]

print(f"Number of unique tokens: {len(dictionary)}")
print(f"Number of documents: {len(corpus)}")

# LDA実行
num_topics = 5
lda = LdaModel(corpus, id2word = dictionary, num_topics = num_topics, alpha=0.1)

df =pd.DataFrame()
for t in range(num_topics):
        word=[]
        for i, prob in lda.get_topic_terms(t, topn=31):
            word.append(dictionary.id2token[int(i)])
        anser = pd.DataFrame([word],index=[f'topic{t+1}'])
        df = pd.concat([df, anser])
       # print(df.T)
df.T

# pyLDAvisの実行

vis = pyLDAvis.gensim_models.prepare(lda, corpus, dictionary, sort_topics = False, mds = 'mmds')

pyLDAvis.save_html(vis, 'J17-SE01_output.html')
