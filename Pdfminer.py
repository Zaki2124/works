#input
from pdfminer.pdfpage import PDFPage
from pdfminer.pdfinterp import PDFResourceManager,PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams


#読み込みたいPDFファイル
input_file = open('J17-IS-report.pdf', 'rb')

#書き込みたいテキストファイル
output_file = open('J17-IS.txt', 'w')

#Layout Analysisのパラメーターを設定
laparams = LAParams()
laparams

#共有リソースを格納するPDFリソースマネージャーオブジェクトを作成
resource_manager = PDFResourceManager()
resource_manager

#テキストに変換
device = TextConverter(resource_manager, output_file, laparams=laparams)
device

#ページの内容を処理するためのPDFインタプリタオブジェクトを作成
Interpreter = PDFPageInterpreter(resource_manager, device)
Interpreter

#ドキュメントに含まれる各ページの処理
for page in PDFPage.get_pages(input_file):
    Interpreter.process_page(page)