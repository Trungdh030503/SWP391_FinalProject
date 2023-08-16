import  requests
from bs4 import BeautifulSoup


response = requests.get('https://www.udemy.com/topic/api-testing/')


with open('output.txt', 'r', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    
soup = BeautifulSoup(content,"html.parser")
    
# print(soup)
titles = soup.findAll(class_='ud-heading-md course-card--course-title--vVEjC')
print(len(titles))
# page = soup.find('h1', class_='ud-heading-serif-xxl')


# print(page)
links = [link.find('a')['href'] for link in titles]

# print('https://www.udemy.com' + links[1])

# with open('output.txt', 'w') as file:
#     # Write the soup contents to the file
#     file.write(str(soup))
    
    
for link in links:
    course = requests.get('https://www.udemy.com' + link)
    print(course.content)
    # soup = BeautifulSoup(course.content, "html.parser")
    # title = soup.find('ud-heading-xl clp-lead__title clp-lead__title--small')
    # print(title)
    # print(link)

    