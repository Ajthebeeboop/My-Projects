from bs4 import BeautifulSoup
import requests 

url = "https://myanimelist.net/anime/season"

r = requests.get(url)
soup = BeautifulSoup(r.content, 'html.parser')

headers = {
    'User-agent': 'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070213 BonEcho/2.0.0.2pre'
}

li = soup.find_all('div', class_ = 'js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-1')
titles = []
Reurl = []
rating = []
dates = []
genres = []

for item in li:
     first_link =  item.find('a', href = True)
     date = (item.find('span', class_='item').text)
     genre_div = item.find('div', class_='genres-inner js-genre-inner')
     genre = genre_div.get_text(separator=", ", strip=True)
     dates.append(date)
     genres.append(genre)
     
     if first_link:
      Reurl.append(first_link['href'])
      if len(Reurl) == 10:
        break

for i in range (10):
    testurl = Reurl[i]
    s = requests.get(testurl, headers= headers)
    soup = BeautifulSoup(s.content, 'html.parser')
    title = (soup.find('div', class_ = 'h1-title').text)
    score = (soup.find('div', class_ = 'score-label').text)
    rating.append(score)
    titles.append(title)
   




