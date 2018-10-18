import pandas as pd
import matplotlib.pyplot as plt

df = pd.DataFrame
df = pd.read_csv("D:/Fall'17/MachineLearning/project/stores/stores.csv")
# print("These are the names of the attributes")
print(df.columns.get_values())
# prints the plot
# plt.plot(df['city'])
plt.hist(df['state'], 40)
plt.title("Distributions of stores in different state")
plt.xlabel('States')
plt.xticks(rotation=90)
plt.ylabel('Number Of Stores')
# plt.grid(True)
fig = plt.gcf()
# fig.set_size_inches(50, 50)
plt.subplots_adjust(bottom=0.4)
plt.show()
