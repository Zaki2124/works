import MeCab
import sys
import re
import csv
import pandas as pd

#ファイル読み込み
Syllabus = r'J17-SE-report.txt'
with open(Syllabus) as na:
    na_text = na.read()

# 空行の削除
na_text = re.sub('\n\n', '\n', na_text)

#MeCabで形態素解析
mario= MeCab.Tagger()                      #MeCabのインスタンスを作成

na_parsed = mario.parse(na_text)

#行単位に分割
na_parsed_lines = na_parsed.split('\n')

#処理に使うリストを作成
na_parsed_words = []
na_words = []

#各行のタブ(\t)を除去 
for na_parsed_line in na_parsed_lines:
    na_parsed_words.append(re.split('[\t]', na_parsed_line))

# 単語ごとに品詞などを表示
for n in range(len(na_parsed_words)):
    for i in range(len(na_parsed_words[n])):
        print(na_parsed_words[n][i], "\t", end = "")
    print()
print()

# 名詞・一般もしくは固有名詞に該当する単語をリストに格納
for na_parsed_word in na_parsed_words:
    if(     na_parsed_word[0] not in ('EOS', '')
       and  na_parsed_word[1] == '名詞'):
        
        na_words.append(na_parsed_word[0])
     
#結果の出力
data = na_parsed_words
df = pd.DataFrame(data)

df.to_csv('J17-SE-1.csv', index = False, encoding='utf-8')