"""
Arquivo contem uma classe que testa atualizar um livro no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager


class UpdateBook(unittest.TestCase):
    """
    Classe para testar o U do CRUD da entidade Book.
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_update_book(self):
        """
        Método que testa a função Update Book na livraria asafe.
        """
        self.browser.get("http://localhost:8080/projeto-livraria/readBooks")
        time.sleep(0.5)
        self.browser.find_element(By.CLASS_NAME, "edit-book").click()
        self.browser.find_element(By.ID, "input-cadastrar").click()
        assert self.browser.current_url == \
            "http://localhost:8080/projeto-livraria/html/successfully-updated.jsp"

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()
