import MeCab
wakati = MeCab.Tagger("-Owakati")
wakati.parse("本学電子情報学系でも，電気・電子工学から情報工学まで幅広く学ぶことが可能なカリキュラムが用意されている．")

tagger = MeCab.Tagger()
print(tagger.parse("本学電子情報学系でも，電気・電子工学から情報工学まで幅広く学ぶことが可能なカリキュラムが用意されている．"))