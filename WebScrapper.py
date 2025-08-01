from bs4 import BeautifulSoup 
import requests 
#url of animelist (Seasonal)
url = "https://myanimelist.net/anime/season"
# Send an HTTP GET Request to the website
r = requests.get(url)

#Parse all html content
soup = BeautifulSoup(r.content, 'html.parser')

#Passes that it's a request from a real browser
headers = {
    'User-agent': 'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070213 BonEcho/2.0.0.2pre'
}

#Uses BeautifulSoup to find all necessary contents(Title, Url, Rating, Date, and Genre)
li = soup.find_all('div', class_ = 'js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-1')
titles = []
Reurl = []
rating = []
dates = []
genres = []

#Runs through the Main list 
for item in li:
     #Finds the url of the anime using "a" and checks if it was a reference
     first_link =  item.find('a', href = True)
     #Finds the date of the anime using "span" and turns it into text
     date = (item.find('span', class_='item').text)
     #Finds the div the genre content and stips them down to necessary contents separated by","
     genre_div = item.find('div', class_='genres-inner js-genre-inner')
     genre = genre_div.get_text(separator=", ", strip=True)

     #adds dates to date list
     dates.append(date)
     #adds genres to genre list
     genres.append(genre)
     
     if first_link:
      #Appends url of anime
      Reurl.append(first_link['href'])
      #Stops at 10 items due 
      if len(Reurl) == 10:
        break


for i in range (10):
    #runs through each top 10 url
    testurl = Reurl[i]
    s = requests.get(testurl, headers= headers)
    soup = BeautifulSoup(s.content, 'html.parser')
    #Finds title by the provided class name then turns it to text
    title = (soup.find('div', class_ = 'h1-title').text)
    #Finds score by the provided class name then turns it to text
    score = (soup.find('div', class_ = 'score-label').text)
    #adds score to rating list
    rating.append(score)
    #adds title to titles list
    titles.append(title)
   




