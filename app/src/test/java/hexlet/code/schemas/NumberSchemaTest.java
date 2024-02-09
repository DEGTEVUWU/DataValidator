package hexlet.code.schemas;

class NumberSchemaTest {
    /*
    private final int notAMagicNumberForTests3 = 3;
    private final int notAMagicNumberForTests6 = 6;
    private final int notAMagicNumberForTests12 = 12;
    private final int notAMagicNumberForTest5 = 5;
    private final Integer notAMagicNumberForTestNull = null;
    private final int notAMagicNumberForTestMinus5 = -5;

    @Test
    void requiredMethodTest() {
        var actual1 = new NumberSchema();

        actual1.setAllowNull(true);

        var expected1 = new NumberSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);

    }

    @Test
    void positiveMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setAllowPositive(true);

        var expected1 = new NumberSchema();
        expected1.positive();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void rangeMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setMinRange(notAMagicNumberForTests3);
        actual1.setMaxRange(notAMagicNumberForTests6);

        var expected1 = new NumberSchema();
        expected1.range(notAMagicNumberForTests3, notAMagicNumberForTests6);

        assertThat(actual1.getMinRange()).isEqualTo(expected1.getMinRange());
        assertThat(actual1.getMaxRange()).isEqualTo(expected1.getMaxRange());

    }

    @Test
    void isValidMethodTest() {
        var obj1 = new NumberSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid(notAMagicNumberForTests12);

        var obj2 = new NumberSchema();
        obj2.setAllowPositive(true);
        var actual2 = obj2.isValid(notAMagicNumberForTests12);

        var obj3 = new NumberSchema();
        obj3.setMinRange(notAMagicNumberForTests3);
        obj3.setMaxRange(notAMagicNumberForTests6);
        var actual3 = obj3.isValid(notAMagicNumberForTest5);

        var expectedObj1 = new NumberSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid(notAMagicNumberForTests12);

        var expectedObj2 = new NumberSchema();
        expectedObj2.positive();
        var expected2 = expectedObj2.isValid(notAMagicNumberForTests12);

        var expectedObj3 = new NumberSchema();
        expectedObj3.range(notAMagicNumberForTests3, notAMagicNumberForTests6);
        var expected3 = expectedObj3.isValid(notAMagicNumberForTest5);

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);


    }
    @Test
    void isValidMethodTestWithFalseResult() {

        var obj4 = new NumberSchema();
        obj4.setAllowNull(true);
        var actual4 = obj4.isValid(notAMagicNumberForTestNull);

        var obj5 = new NumberSchema();
        obj5.setAllowPositive(true);
        var actual5 = obj5.isValid(notAMagicNumberForTestMinus5);

        var obj6 = new NumberSchema();
        obj6.setMinRange(notAMagicNumberForTests3);
        obj6.setMaxRange(notAMagicNumberForTests3);
        var actual6 = obj6.isValid(notAMagicNumberForTestMinus5);

        assertThat(actual4).isFalse();
        assertThat(actual5).isFalse();
        assertThat(actual6).isFalse();

    }

     */
}
