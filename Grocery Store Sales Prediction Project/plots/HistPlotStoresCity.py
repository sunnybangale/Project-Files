import pandas as pd
import matplotlib.pyplot as plt

df = pd.DataFrame
df = pd.read_csv("D:/Fall'17/MachineLearning/project/stores/stores.csv")
# print("These are the names of the attributes")
# print(df.columns.get_values())
# prints the plot
# plt.plot(df['city'])
plt.hist(df['state'], 40)
plt.title("Distributions of stores in different cities")
plt.xlabel('Cities')
plt.xticks(rotation=90)
plt.ylabel('Number of Stores')
# plt.grid(True)
fig = plt.gcf()
# fig.set_size_inches(50, 50)
plt.subplots_adjust(bottom=0.4)
plt.show()
