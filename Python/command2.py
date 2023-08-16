import csv
import requests
from bs4 import BeautifulSoup



beptu = ['bep-tu-don', 'bep-tu-doi', 'bep-tu-ba', 'bep-tu-bon', 'bep-da-diem', 'bep-tu-domino']

number = 1
# Open the CSV file in write mode
with open('beptu.csv', 'w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)

    # Write the header row
    writer.writerow(['Index','Title', 'Supplier', 'Price', 'Category', 'Warranty', 'ModelNumber', 'Description', 'ImageUrl'])
    for subcat in beptu:
        last_page = 0
        try:
            response = requests.get('https://bep247.vn/' + subcat)
            soup = BeautifulSoup(response.content, 'html.parser')
            last_page_link = soup.find('li', class_='last').find('a')['href']
            last_page = int(last_page_link.split('page=')[-1])
        except: Exception

        for i in range(1, last_page + 1):
            response = requests.get('https://bep247.vn/' + subcat + '?brand=&min=&max=&origin=&warranty=&type=&size=&power=&design=&orderby=&page=' + str(i))
            soup = BeautifulSoup(response.content, "html.parser").find('ul', class_='topiccol5')      
            # print(soup)
            products = soup.findAll('li')
            
            # data = {}
            for product in products:
                
                title = product.find('h3').text.strip()
                # print(title)
                price = product.find('div', class_='topicact').find('label').text.strip()
                # print(price)    
                # data[title] = price
                
                link = product.find('a')['href']
                
                # print(link)
                
                page = requests.get('https://bep247.vn' + link)
                
                soup = BeautifulSoup(page.content, "html.parser")
                # find('div', class_='product-detail__short-des')
                # print(product)
                try: 
                    description = soup.find('article', class_='imore product-detail-body')
                    paras = description.findAll('p')
                    lines = ''
                    for para in paras:
                        line = para.get_text(strip=True)
                        lines = lines + line + '<br>'
                    image_url = product.find('img')['src']
                    # print(image_url)
                    prefix = "https://static.bep247.vn/"

                    # Remove the prefix from the link
                    # print(image_url)
                    # url = "https://static.bep247.vn/2020/06/14/958fe46dcc74312a6865.jpg"
                    new_url = image_url.replace("https://static.bep247.vn/", "")
                    new_url = new_url.replace("/", "-")
                    
                    # print(new_url)
                    # print(result)
                    h2s = soup.find('div', class_='product-detail__short-des').findAll('h2')
                    
                    modelnumber = ''
                    catgory = ''
                    supplier = ''
                    warranty = ''
                    for h2 in h2s:
                        if h2.find('label').text == 'Mã sản phẩm':
                            modelnumber = h2.find('a').text
                        if h2.find('label').text == 'Danh mục':
                            catgory = h2.find('a').text
                        if h2.find('label').text == 'Hãng sản xuất':
                            supplier = h2.find('a').text
                        if h2.find('label').text == 'Bảo hành':
                        # print(h2)
                            warranty = h2.contents[-1].strip()
                            
                            
                    # print(image_url)
                    image = requests.get(image_url)
                    
                    with open('image/' +  new_url, "wb") as file:
                        file.write(image.content)
                    
                        print("Image downloaded successfully as", new_url)
                    
                    writer.writerow([number, title, supplier, price, catgory, warranty, modelnumber, lines, new_url])
                    number += 1
                except: Exception
                
                # parag = description.get_text(strip=True)
                # lines = parag.splitlines()
                # for line in lines:
                    
                # print(lines)
                # try:
                #     for para in pasas:
                #         parag = parag + para.text 
                # except Exception:
                #     para = ''
                    
                
                
            
            
        # for index, (title, price) in enumerate(data.items(), start=1):
            

        # for title, price in data.items():
        #     writer.writerow([title, price])
        
        # links = [link.find('a')['href'] for link in titles]



        # for link in links:
        #     products = requests.get('https://bep247.vn' + link)
        #     title = BeautifulSoup(products.content, "html.parser").find('li', class_='active').text


        #     soup = BeautifulSoup(products.content, "html.parser").find('tbody')
        #     try:
        #         table_rows = soup.find_all('tr')
                
        #         data = {}
        #         for row in table_rows:
        #             cells = row.find_all('td')
        #             if len(cells) == 2:
        #                 label = cells[0].text.strip()
        #                 value = cells[1].text.strip()
        #                 data[label] = value

        #         # Write the data to the CSV file
        #         for label, value in data.items():
        #             writer.writerow([title, label, value])
        #     except:
        #         print(link)
                