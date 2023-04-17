"""
Arquivo que contem uma classe responsável por testar a busca de um livro na livraria asafe.
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from consts_book import URL_READ_BOOKS, XPATH_ID_BOOK


class TestFindBookById(unittest.TestCase):
    """
    Classe que realiza o teste de busca de um livro pelo id
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_find_book_by_id(self):
        """
        Método que realiza o teste de busca de um livro pelo id
        """
        self.browser.get(URL_READ_BOOKS)
        id_element = self.browser.find_element(By.XPATH, XPATH_ID_BOOK)
        html_page = self.browser.page_source
        if "Nenhum livro foi cadastrado" in html_page:
            raise AssertionError("Não existe livros cadastrados.")
        else:
            id_value = id_element.text
            input_search_id = self.browser.find_element(
                By.CLASS_NAME, "search-input-by-id")
            input_search_id.click()
            input_search_id.send_keys(id_value + Keys.ENTER)
            html = self.browser.page_source
            self.assertIn(id_value, html)

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
