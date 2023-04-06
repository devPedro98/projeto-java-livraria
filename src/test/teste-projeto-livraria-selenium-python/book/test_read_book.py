"""
Arquivo que contem uma classe responsável por testar a leitura de um livro na livraria asafe.
"""
import unittest
import time
from selenium.webdriver.chrome.service import Service
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from consts import URL_READ_BOOKS


class TestReadBook(unittest.TestCase):
    """
    Classe responsável pelo R do CRUD
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_read_book(self):
        """
        Método responsável por fazer o teste de leitura de livro
        """
        self.browser.get(URL_READ_BOOKS)
        html_page = self.browser.page_source
        self.assertNotIn("Nenhum livro foi cadastrado", html_page)

    def tearDown(self):
        time.sleep(1)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
