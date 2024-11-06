#LDA
import pandas as pd
import MeCab
import re
from sklearn.feature_extraction.text import CountVectorizer
from gensim.corpora.dictionary import Dictionary
from gensim.models import LdaModel
from tqdm import tqdm
import numpy as np
import csv

#Ismap
from sklearn.manifold import Isomap
from sklearn import datasets
import sklearn.decomposition
import matplotlib.pyplot as plt
import seaborn as sns
sns.set()
import warnings
warnings.filterwarnings('ignore')

#データ読み込み
def main():
    df = pd.read_csv("ku-se.csv", encoding='shift-jis',index_col=0).reset_index()       # 読み込みファイル選択
    df.head(1000)

    #形態素解析の実行
    syllabus = make_docs(df,0)

    #辞書の作成
    dictionary = Dictionary(syllabus)

    # LdaModelが読み込めるBoW形式に変換
    corpus = [dictionary.doc2bow(text) for text in syllabus]

    print(f"Number of unique tokens: {len(dictionary)}")
    print(f"Number of documents: {len(corpus)}")

    #LDA実行
    num_topics = 5
    lda = LdaModel(corpus, id2word = dictionary, num_topics = num_topics, alpha=0.01)

    df =pd.DataFrame()
    for t in range(num_topics):
        word=[]
        for i, prob in lda.get_topic_terms(t, topn= 200):
            word.append(dictionary.id2token[int(i)])
        anser = pd.DataFrame([word],index=[f'topic{t+1}'])
        df = pd.concat([df, anser])
        print(df.T)

    return 0

#Nelogdによるトーカナイザー
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

#df全体に対してmecab_tokenizerを適用し、形態素解析を行なったリストを返す関数
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

if __name__ == "__main__":
    main()
    
#Ismapの実行

##データ読み込み
dataset = datasets.load_digits()

x = dataset.data
y = dataset.target
    
target_names = dataset.target_names

##Isomap
n_neighbors = 30
isomap = Isomap(n_neighbors = 30, n_components=2)
X_iso = isomap.fit(x).transform(x)

## colors
colors = [plt.cm.nipy_spectral(i/10, 1) for i in range(50)]

## plot
plt.figure()
for c, target_name  in zip(colors, target_names):
    plt.scatter(X_iso[y == target_name, 0], X_iso[y == target_name, 1], c=c, label = target_name)
plt.legend()
plt.title('J17-cs')
plt.savefig('./J17-se0.png')