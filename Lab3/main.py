import temp as temp
from selenium import webdriver
from selenium.common import NoSuchElementException
from selenium.webdriver.common.by import By
import logging

from selenium.webdriver.remote.webelement import WebElement

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(executable_path='D:\TAU\Lab3\chromedriver.exe')


logger.info('Going on site armyworld.pl')
driver.get('https://www.armyworld.pl/')
checktools = driver.find_element(By.XPATH, '//*[@id="menu_navbar"]/ul/li[3]/a').click()
#click narzedzia on site
checkToolByTakeItToBasket = driver.find_element(By.XPATH, '//*[@id="search"]/div[1]/div[2]/form/button').click()
#add to basket
checkBasket = driver.find_element(By.XPATH, '//*[@id="menu_basket"]/a').click()
#checking is the item is in basket
checkIteminBasket = driver.find_element(By.XPATH, '//*[@id="Basket"]/form/div[1]/div[2]/div[2]/div[1]/div/h3/a')

button0 = driver.find_element(By.XPATH,'//*[@id="ckdsclmrshtdwn_v2"]/span')
button0.click()
button = driver.find_element(By.XPATH, '/html/body/div[1]/header/div[3]/div[2]/a')
button.click()
logger.warning('Jakieś ostrzeżenie')
# go to login site
button1 = driver.find_element(By.XPATH, '//*[@id="menu_additional"]/a')

# button2 = driver.find_element(By.XPATH('//*[@id="user_login"]')).send_keys("login")
# button3 = driver.find_element(id('user_pass')).send_keys("login")
# logger.error('Jakiś Error')
username = "cokolwiek"
userpassword = "cefsds"
driver.get("https://armyworld.pl/signin.php")
driver.find_element(By.ID,'user_login').send_keys(username)
driver.find_element(By.ID,'user_pass').send_keys(userpassword)


driver.close()




