"""
Arquivo contem uma classe que testa deletar um livro no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_book import URL_READ_BOOKS


class TestDeleteBook(unittest.TestCase):
    """
    Classe responsável por realizar teste de deletar um livro do site livraria asafe.
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_delete_book(self):
        """
        Método responsável por testar a exclusão de um livro
        """
        self.browser.get(URL_READ_BOOKS)
        input_id = self.browser.find_element(
            By.CLASS_NAME, "search-input-by-id")
        input_id.click()
        input_id.send_keys("Deletar")
        time.sleep(0.5)
        element = self.browser.find_element(By.CLASS_NAME, "button-delete")
        element.click()
        time.sleep(0.5)
        alert = self.browser.switch_to.alert
        alert.accept()
        input_id = self.browser.find_element(
            By.CLASS_NAME, "search-input-by-id")
        assert input_id.get_attribute("value") == ""

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
