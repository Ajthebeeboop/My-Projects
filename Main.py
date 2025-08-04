from tkinter import *
from tkinter import ttk
from tkcalendar import Calendar
import file as f

def clearing():
    e1.delete(0,END)
    e2.delete(0,END)
    day.current(0)
    month.current(0)
    year.current(0)
    

def submitting():
    name = e1.get()
    amount = int(e2.get())
    date = str(day.get()+"/"+ month.get()+"/" +year.get())
    type = type_var.get()
    f.initialize_csv()
    f.add_entry(f.file, date,amount,type,name)
    



Front = Tk()
Front.geometry("300x200")
Front.resizable(False, False)
Front.title("Finance Calculator")

Label(Front, text="Name: ").grid(row=0, column=0, sticky=W, padx=10, pady=5)
Label(Front, text="Amount: ").grid(row=1, column=0, sticky=W, padx=10, pady=5)
Label(Front, text="Date: ").grid(row=2, column=0, sticky=W, padx=10, pady=5)
Label(Front, text="Type: ").grid(row=3, column=0, sticky=W, padx=10, pady=5)
e1 = Entry(Front, width=30)
e2 = Entry(Front, width=30)

date_var = StringVar()
e3 = Frame(Front)
day = ttk.Combobox(e3, width= 5, values= [str(i) for i in range (1,32)])
month = ttk.Combobox(e3,width= 5, values= [' Jan', 
                    ' Feb',
                    ' Mar',
                    ' Apr',
                    ' May',
                    ' Jun', 
                    ' Jul', 
                    ' Aug', 
                    ' Sep', 
                    ' Oct', 
                    ' Nov', 
                    ' Dec'])
year = ttk.Combobox(e3,width= 5,values= [str(i) for i in range (2025,2101)])
day.current(0)
month.current(0)
year.current(0)
day.pack(side=LEFT, padx=10)
month.pack(side=LEFT, padx=10)
year.pack(side=LEFT, padx=10)

e4 = Frame(Front)
type_var = StringVar(value="Income")
cho = Radiobutton(e4, text="Income",variable=type_var,value="Income")
cho2 = Radiobutton(e4, text="Expenses",variable=type_var,value="Expenses")
cho.pack(side=LEFT, padx=10)
cho2.pack(side=LEFT, padx=10)
e1.grid(row=0, column=1, padx=10, pady=5)
e2.grid(row=1, column=1, padx=10, pady=5)
e3.grid(row=2, column=1, padx=10, pady=5)
e4.grid(row=3, column=1, padx=10, pady=5)


button_frame = Frame(Front)
button_frame.grid(row=4, column=0, columnspan=2, pady=15)

submit_btn = Button(button_frame, text="Submit", width=12, command=submitting)
clear_btn = Button(button_frame, text="Clear", width=12, command=clearing)
submit_btn.pack(side=LEFT, padx=10)
clear_btn.pack(side=LEFT, padx=10)
Front.mainloop()
