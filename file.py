import csv
import pandas as pd

file = "Expenses_data.csv"

def initialize_csv():
        #checks if there is already a file name like this
        try:
            pd.read_csv(file)
        #creates one if there is no file with the name
        except FileNotFoundError:
            df = pd.DataFrame(columns=["date, amount, category, description"])
            df.to_csv(file, index= False)
   
def add_entry (file, date, amount, category, description):
        new_entry = {
            "date": date,
            "amount": amount,
            "category":category,
            "description": description
        }
        with open (file, "a", newline="") as csvfile:
            writer = csv.DictWriter(csvfile, fieldnames=new_entry)
            writer.writerow(new_entry)




