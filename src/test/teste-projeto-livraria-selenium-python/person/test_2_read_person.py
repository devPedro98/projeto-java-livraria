"""
Arquivo contem uma classe que testa ler um leitor no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_person import URL_READ_LEITORES


class TestReadPerson(unittest.TestCase):
    """
    Classe responsável por realizar o R do CRUD da entidade Leitor
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_read(self):
        self.browser.get(URL_READ_LEITORES)
        html = self.browser.page_source
        self.assertNotIn("Nenhum leitor cadastrado",html)

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
