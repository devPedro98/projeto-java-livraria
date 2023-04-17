"""
Arquivo contem uma classe que testa atualizar um leitor no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_person import URL_READ_LEITORES, URL_SUCCESSFULY_UPDATED_PERSON


class TestUpdatePerson(unittest.TestCase):
    """
    Classe responsável por realizar o test do U do CRUD da entidade Leitor
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_read(self):
        self.browser.get(URL_READ_LEITORES)
        button_edit = self.browser.find_element(By.CLASS_NAME, "update-button")
        button_edit.click()
        button_submit = self.browser.find_element(By.CLASS_NAME, "my-btn")
        button_submit.click()
        assert self.browser.current_url == URL_SUCCESSFULY_UPDATED_PERSON

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
