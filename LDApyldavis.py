import glob
import numpy as np
import pandas as pd
from tqdm import tqdm
np.random.seed(0)

df = glob.glob("J17-IT.csv")
len(df) 

print(open(df[0], 'r').read())


#Ismapの実行

