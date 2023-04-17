"""
Arquivo contem uma classe que testa deletar um leitor no site livraria-asafe
"""
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from consts_person import URL_READ_LEITORES


class TestDeletePerson(unittest.TestCase):
    """
    Classe responsável por realizar o D do CRUD na entidade Leitor
    """

    def setUp(self):
        service = Service(ChromeDriverManager().install())
        self.browser = webdriver.Chrome(service=service)

    def test_delete(self):
        self.browser.get(URL_READ_LEITORES)
        btns_delete = self.browser.find_elements(By.CLASS_NAME, "delete-button")
        if "Nenhum leitor cadastrado" not in self.browser.page_source:
            first_btn_delete = btns_delete[0]
            link = first_btn_delete.get_attribute("href")
            first_btn_delete.click()
            alert = self.browser.switch_to.alert
            alert.accept()
            self.assertNotIn(link, self.browser.page_source)
        else:
            raise AssertionError("Nenhum leitor cadastrado para poder efetuar o DELETE")

    def tearDown(self):
        time.sleep(1.5)
        self.browser.quit()


if __name__ == '__main__':
    unittest.main()
