import pandas as pd
import MeCab
from sklearn.feature_extraction.text import CountVectorizer
from gensim.corpora.dictionary import Dictionary
from gensim.models import LdaModel
from sklearn.manifold import Isomap
import matplotlib.pyplot as plt
import seaborn as sns
sns.set()
import warnings
warnings.filterwarnings('ignore')

# データ読み込み
def main():
    # CSVファイルの読み込み
    df = pd.read_csv("K-J17-IS.csv", encoding='shift-jis', index_col=0).reset_index()

    # 形態素解析の実行
    syllabus = make_docs(df, 0)

    # 辞書の作成
    dictionary = Dictionary(syllabus)

    # BoW形式に変換
    corpus = [dictionary.doc2bow(text) for text in syllabus]

    print(f"Number of unique tokens: {len(dictionary)}")
    print(f"Number of documents: {len(corpus)}")

    # LDAの実行
    num_topics = 5
    lda = LdaModel(corpus, id2word=dictionary, num_topics=num_topics, alpha=0.01)

    # トピックごとの単語を表示
    df_topics = pd.DataFrame()
    for t in range(num_topics):
        words = [dictionary.id2token[int(i)] for i, _ in lda.get_topic_terms(t, topn=200)]
        df_topics = pd.concat([df_topics, pd.DataFrame([words], index=[f'topic{t+1}'])])
    print(df_topics.T)

    # Isomapの実行
    run_isomap(df)

    return 0

# Mecabによるトーカナイザー
def mecab_tokenizer(text):
    m = MeCab.Tagger('-d /usr/lib/x86_64-linux-gnu/mecab/dic/mecab-ipadic-neologd')
    m.parse('')
    tokens = []
    node = m.parseToNode(text)
    while node:
        if node.surface and node.feature.split(',')[0] == "名詞" and node.feature.split(',')[1] != "数":
            tokens.append(node.surface)
        node = node.next
    return tokens

# DataFrameに対して形態素解析を適用
def make_docs(df, column_number):
    docs = []
    for i in range(len(df)):
        text = df.iloc[i, column_number]
        docs.append(mecab_tokenizer(text))
    return docs

# Isomapの実行
def run_isomap(df):
    # Isomap用にデータを変換
    vectorizer = CountVectorizer(tokenizer=mecab_tokenizer)
    X = vectorizer.fit_transform(df.iloc[:, 0]).toarray()

    # Isomapの実行
    n_neighbors = 30
    isomap = Isomap(n_neighbors=n_neighbors, n_components=2)
    X_iso = isomap.fit_transform(X)

    # プロット
    plt.figure()
    plt.scatter(X_iso[:, 0], X_iso[:, 1], c='blue', label='Documents')
    plt.legend()
    plt.title('Isomap of Documents')
    plt.savefig('./J17-se0.png')

if __name__ == "__main__":
    main()
