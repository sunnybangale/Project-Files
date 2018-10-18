import pandas as pd
import matplotlib.pyplot as plt

df = pd.DataFrame
df = pd.read_csv("D:/Fall'17/MachineLearning/project/stores/stores.csv")
# print("These are the names of the attributes")
print(df.columns.get_values())
# prints the plot
# plt.plot(df['city'])
plt.hist(df['type'])
plt.title("Distributions of store's type")
plt.xlabel('Store Type')
# plt.xticks(rotation=90)
# plt.grid(True)
plt.ylabel('Number of Stores')
fig = plt.gcf()
# fig.set_size_inches(50, 50)
plt.show()
