import  requests
from bs4 import BeautifulSoup

rows_inserted = 0
category_list = ['bep-gas-am', 'bep-gas-duong', 'bep-gas-am-hong-ngoai', 'bep-gas-hong-ngoai']

# for i in category_list:
#     response = reque

for i in range(1, 6):

    response = requests.get('https://bep247.vn/bep-gas-am?brand=&min=&max=&origin=&warranty=&type=&size=&power=&design=&orderby=&page=' + str(i))

    soup = BeautifulSoup(response.content,"html.parser")

    titles = soup.findAll('div', class_='topictop')

    links = [link.find('a')['href'] for link in titles]

    


    for link in links:
        # print(link)
        products = requests.get('https://bep247.vn' + link)
        
        # soup = BeautifulSoup(products.content, "html.parser").find('div', class_='product-detail__short-des')

        title = BeautifulSoup(products.content, "html.parser").find('li', class_='active')
        print(title.text)
        
        soup = BeautifulSoup(products.content, "html.parser").find('tbody')
        table_rows = soup.find_all('tr')

        data = {}
        for row in table_rows:
            cells = row.find_all('td')
            if len(cells) == 2:
                label = cells[0].text.strip()
                value = cells[1].text.strip()
                data[label] = value

        Print the extracted data
        for label, value in data.items():
            print(label + ':', value)
        
        # h2s = soup.findAll('h2')
        # for h2 in h2s:
        #     label = h2.find('label').text.strip()
        #     if (label == 'Hãng sản xuất'):
        #         brand = h2.find('a').text.strip()
        #         print(brand)
        #     if (label == 'Mã sản phẩm'):
        #         productcode = h2.find('a').text.strip()
        #         print(productcode)
        #     if (label == 'Xuất xứ'):
        #         origin = h2.contents[-1].replace(":", "").strip()
        #         print(origin)
        #     if (label == 'Bảo hành'):
        #         warranty = h2.contents[-1].replace(":", "").strip()
        #         print(warranty)


    

# for title in titles:
#     print(title)