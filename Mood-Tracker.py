import datetime as dt

try:
    f  = open("MoodTracker.txt", "x")
    f.write("Date,time,Mood,Description,Intensity\n")
    f.close()
except(FileExistsError):
    print("File Already Exists! so I will open the recent one ")

x = dt.datetime.now()
print("Welcome to the Daily mood tracker! What brings you this " + x.strftime("%A"))
while True:
   x = dt.datetime.now()
   A = input("Choices: \n1. New Entry \n2. Check File \n3. Quit\n Input - ")
   if (A == "1"):
        k = input("What's your mood: ")
        j = input("Can you tell me Why?: ")
        while True:
            z = int(input ("How intense is it(1-10):  "))
            if z >= 1 and z <= 10:
                break
            else:
                print("Not in the range, try again!")
                
        with open("MoodTracker.txt", "a") as f:    
            f.write(x.strftime("%x") + "," + x.strftime("%I" +":" + "%M " + "%p") +"," +k+","+j+","+str(z)+" out of 10"+"\n")
            print("Entry added!")
            f.close()
   elif (A == "2"):
       with open("MoodTracker.txt", "r") as f:
        print(f.read())
        f.close()
   elif (A == "3"):
       quit()
   else:
       print("That's not a choice")
    



