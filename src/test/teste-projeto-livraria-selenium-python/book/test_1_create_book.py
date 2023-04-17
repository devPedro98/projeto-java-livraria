"""
Arquivo contem uma classe que testa criar um livro no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_book import URL_READ_BOOKS, URL_SUCESSFULLY_REGISTERED_BOOK


class TestCreateBook(unittest.TestCase):
    """
    Classe para testar o C do CRUD da entidade Book.
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_create_book(self):
        """
        Método abre o site livraria-asafe na página de livros
        e preenche o formulário e cadastra no banco.
        """
        self.browser.get(URL_READ_BOOKS)
        self.browser.find_element(By.ID, "button-add-book").click()
        self.fill_form("book-name", "book-author", "book-category")
        self.browser.find_element(By.ID, "button-cadastrar").click()
        assert self.browser.current_url == \
            URL_SUCESSFULLY_REGISTERED_BOOK

    def fill_form(self, id_book: str, id_author: str, id_category: str):
        """
        Método auxiliar que preenche o formulário de criar um livro
        """
        book_name = self.browser.find_element(By.ID, id_book)
        book_name.click()
        book_name.send_keys("O homem mais inteligente da historia")
        author_name = self.browser.find_element(By.ID, id_author)
        author_name.click()
        author_name.send_keys("Augusto Cury")
        category_name = self.browser.find_element(By.ID, id_category)
        category_name.click()
        category_name.send_keys("Romance")

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
