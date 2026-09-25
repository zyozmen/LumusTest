package com.sdet.test.runners;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.sdet.test.tests.AutomationTest;

@Suite
@SelectClasses(AutomationTest.class)
public class AutomationTestSuite {
    
}
