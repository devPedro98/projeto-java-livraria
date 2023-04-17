"""
Arquivo contem uma classe que testa criar um leitor no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_person import URL_READ_LEITORES, URL_SUCCESSFULY_REGISTERED_PERSON


class TestCreatePerson(unittest.TestCase):
    """
    Classe para testar o C do CRUD da entidade Person
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_create_person(self):
        self.browser.get(URL_READ_LEITORES)
        self.browser.find_element(By.ID, "botao-cadastrar").click()
        options = self.browser.find_elements(By.CLASS_NAME, "option-book")
        if len(options) > 0:
            self.fill_form_register()
            self.browser.find_element(By.ID, "cadastrar-pessoa").click()
            assert self.browser.current_url == URL_SUCCESSFULY_REGISTERED_PERSON
        else:
            raise AssertionError("Não existe livros cadastrados.")

    def fill_form_register(self):
        name = self.browser.find_element(By.ID, "nome")
        surname = self.browser.find_element(By.ID, "sobrenome")
        name.click()
        name.send_keys("Eliana Santos")
        surname.click()
        surname.send_keys("Barrios")
        self.select_book()

    def select_book(self):
        select = self.browser.find_element(By.ID, "livro")
        actions = ActionChains(self.browser)
        actions.click(select)
        actions.send_keys(Keys.ARROW_DOWN)
        actions.send_keys(Keys.ENTER)
        actions.perform()

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
