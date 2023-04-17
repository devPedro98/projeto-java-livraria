import unittest
from test_1_create_person import TestCreatePerson
from test_3_update_person import TestUpdatePerson
from test_2_read_person import TestReadPerson
from test_4_delete_person import TestDeletePerson

test_suite = unittest.TestSuite()

test_suite.addTest(unittest.makeSuite(TestCreatePerson))
test_suite.addTest(unittest.makeSuite(TestReadPerson))
test_suite.addTest(unittest.makeSuite(TestUpdatePerson))
test_suite.addTest(unittest.makeSuite(TestDeletePerson))

runner = unittest.TextTestRunner()
runner.run(test_suite)
