import unittest
from test_1_create_book import TestCreateBook
from test_2_read_book import TestReadBook
from test_3_update_book import TestUpdateBook
from test_4_delete_book import TestDeleteBook
from test_5_find_book_by_id import TestFindBookById

test_suite = unittest.TestSuite()

test_suite.addTest(unittest.makeSuite(TestCreateBook))
test_suite.addTest(unittest.makeSuite(TestReadBook))
test_suite.addTest(unittest.makeSuite(TestUpdateBook))
test_suite.addTest(unittest.makeSuite(TestFindBookById))
test_suite.addTest(unittest.makeSuite(TestDeleteBook))

runner = unittest.TextTestRunner()
runner.run(test_suite)
