**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#33:    |     |
| -------------- | --- |
| Student Names: |     |
| Lucas Ion      |     |
| Alden Lien     |     |
| Hao Nguyen     |     |
| Nguyen Gia Hy Huynh| |

# 1 Introduction

After discussing with everyone in our group, this was not the first time we had done JUnit testing excpet for Hy which it was his first time doing the testing. Therefore although we did not have extensive experience with JUnit testing, we did have a general idea of what to expect. For the lab this allowed up to hit the ground running, and enter straight into developing high quality tests based on the logic and methodology equivocated in lecture.


# 2 Detailed description of unit test strategy
*DataUtilities.calculateColumnTotal, DataUtilities.calculateRowTotal, DataUtilities.createNumberArray and DataUtilities.createNumberArray2D* tests are implemented based on **Equivalence Class Testing Technique**. Our primary strategy on these methods was listing out all equivalent classes; once test suits are on the table, we start summarizing every edge case could be detected for every partition; after that the test-case implementation is manifest, so we spend time on write clean code so no contamination happens; in the end, we finalize the percentage coverage of each test-case to ensure no error assumption accidentally occurs during the process. 

Our partitions in *calculateColumnTotal and calculateRowTotal* includes:
> 1. Parameterize empty table
> 2. Parameterize single-column/single-row table
> 3. Parameterize multiple-column/multiple-row table
> 4. Index out of bounds exception on a larger/smaller column/row input
> 5. Illegal argument exception on null table input

Our partitions in *DataUtilities.createNumberArray and DataUtilities.createNumberArray2D* includes:

> 1. Parameterize empty array/2D array
> 2. Parameterize a reasonable length array/2D array
> 3. Parameterize MAX_INT length array/2D array
> 4. Illegal argument exception on null input
---
Our partitions in *DataUtilities.clone* includes:
> 1. Parameterize empty array
> 2. Parameterize 2D array
> 3. Parameterize a valid array
---
We used Black-Box testing in form of Equivalance Class Testing. Our partitions in *getLength() and getCentralValue()* includes:
> 1. Upper Bound is greater than 0, Lower Bound is greater than 0 and Upper Bound is greater than Lower Bound
> 2. Upper Bound is less than 0, Lower Bound is less than 0 and Upper Bound is greater than Lower Bound
> 3. Upper Bound is greater than 0, Lower Bound is lower than 0
> 4. Upper Bound is less than Lower Bound

The reason why we divide the range of the upper bound and lower bound into these partitions is these should cover all different ranges that the program can and will counter.

We used Black-Box testing in form of Equivalance Class Testing. Our partitions in *shift(Range base, double delta)* includes:
> 1. delta is greater than 0
> 2. delta is less than 0
> 3. delta is equal to 0
The reason why we devide the range of the variable delta into these partitions is these should cover all values that variable delta should be

---
Black-Box testing was used in the form of Equivalence Class Testing when testing the *getUpperBound and getLowerBound* methods in the Range class. The input of these methods was specified by providing a given Range. The given inputs all affected the same output, which was the Upper or Lower bound being acquired by the getter method. These inputs were divided into subsets of expected inputs and unexpected inputs. In essence, the test cases developed for both methods had 3 expected inputs and 1 unexpected input, testing for general requirements of upper and lower bounds

Our partitions in *getUpperBound and getLowerBound* includes:
> 1. Negative Upper bound, and Negative Lower bound
> 2. Positive Upper bound, and Positive Lower bound
> 3. Same Bounds (Upper and Lower bound same value)
> 4. Illegal bounds where Lower bound is greater than Upper bound


# 3 Test cases developed
## DataUtilities > CalculateColumnTotal and  DataUtilities > CalculateRowTotal

**1. calculateColumnTotalForEmptyTable() and calculateRowTotalForEmptyTable**
> This test-case aims to ensure the method function well even when the mocking data Values2D is empty. It is expected to return the value 0.0 as the table has no value to the output. Otherwise, it fails to cover the partition "Parameterize empty table".

**2. calculateColumnTotalForSingleColumn() and calculateColumnTotalForSingleRow()**
> This test-case aims to cover the basic requirement of the method which is having a single column/row in Values2D. It is expected to return the total value of that given row/column. Otherwise, it fails to cover the partition "Parameterize single-column/single-row table".

**3. calculateColumnTotalForMultipleColumn() and calculateColumnTotalForMultipleRow()**
> This test-case aims to ensure the stability of the method given the big data, specifically Values2D with multiple columns/rows. It is expected to return the total value of that given row/column. Otherwise, it fails to cover the partition "Parameterize multiple-column/multiple-row table"

**4. calculateColumnTotalForInvalidColumn() and calculateRowTotalForInvalidRow()**
> This test-case aims to catch the error entering an out of bounds column/row. It is expected to throw an Index out of bounds exception since the enter column/row is invalid. Otherwise, it fails to cover the partition "Index out of bounds exception on a larger/smaller column/row input"

**5. calculateColumnTotalForNullTable() and calculateRowTotalForNullTable()**
> This test-case aims to catch the error of entering a null values in Values2D parameter. It is expected to throw an Illegal argument exception since the enter Values 2D is a null value. Otherwise, it fails to cover the partition "Illegal argument exception on null table input" partition

## DataUtilities > CreateNumberArray and DataUtilities > CreateNumberArray2D
**1. createNumberArrayTestForEmpty() and createNumberArray2DTestForEmpty()**
> This test-case covers the class empty array/2D array. When the user enters an empty input, the method supposes return an empty converted Number. If it throws any error, the methods fails and needs to debug. Otherwise, it functions well for the partition "Parameterize empty array/2D array" 

**2. createNumberArrayTestForNull() and createNumberArray2DTestForNull()**
> This test-case covers the class null input. When the user enters null value in the input, the method supposes to throw an Illegal argument exception since the input is not valid. If it passes and generates a Number output, the method fails and needs to debug. Otherwise, it functions well for partition "Illegal argument exception on null input"

**3. createNumberArrayTestForDouble() and createNumberArray2DTestForDouble()**
> This test-case covers the class normal double type array/2D array input. It is expected to convert an double array/2D array into Number array/2D array. If the passes, it means the length and contents are reserved. Otherwise, it fails for the partition "Parameterize a reasonable length array/2D array".

**4. createNumberArrayTestForMoreDouble() & createNumberArray2DTestForMoreDouble()**
> This test-cases covers a class that has very long array/2D array. It is expected to convert an double array/2D array into Number array/2D array. If the passes, it means the length and contents are reserved. Otherwise, it fails for the partition "Parameterize MAX_INT length array/2D array" .


## DataUtilities.Clone
**1. check2DClone()**
> This test-case covers a class of 2D array. It is expected to output a shallow copy of the input 2D array. If the comparison between the two versions have identical content, the test passes. Otherwise, it fails for the partition "Parameterize 2D array".

**2. emptyClone()**
> This test-case covers the class empty array/2D array. When the user enters an empty input, the method supposes return a copy of empty array. If it throws any error, the methods fails and needs to debug. Otherwise, it functions well for the partition "Parameterize empty array" 

**3.Parameterize a valid array**
> This test-case covers a class of array. It is expected to output a shallow copy of the input array. If the comparison between the two versions have identical content, the test passes. Otherwise, it fails for the partition "Parameterize valid array".


## Range.LengthTest and Range.CentralValueTest
**1. testCasePositive()** 
> is used to test on range that has positive upper bound and lower bound. In addition, the upper bound is greater than the lower bound. This covers the first partition of the method.

**2. testCaseNegative()** 
>is used to test on range that has negative upper bound and lower bound. In addition, the lower bound is greater than the lower bound. This covers the second partition of the method.

**3. testCasePosiNegi()**
> is used to test on range that has positive upper bound and negative lower bound. This covers the third partition.

**4. testCaseError()** 
> is used to test on error range that has higher lower bound than upper bound. This covers the last partition.

## Range.ShiftTest
**1. testCasePositive()**
> is used to test on positive delta. This covers the first partition.

**2. testCaseNegative()**
> is used to test on negative delta. This covers the second partition.

**3. testCaseZero()** 
> is used to test on delta being zero. This covers the last partition.

## Range.getUpperBound 

**1. negativeUpperBound**
> This test case is the first partition, and is used to test the negative range of the upper bound given as an input. The expected output is the upper bound of the range given as an input.

**2. positiveUpperBound**

> This test case is the second partition, and is used to test the positive range of upper bound given as inputs. The expected output is the upper bound of the range given as an input.

**3. getUpperBoundWithSameBounds**

> This test case is the third partition, and is used to test the getter for the upper bound when the range is zero. The expected output is the upper bound of the range given as an input when the lower and upper bounds are the same.

.**3. illegalBounds**

> This test case is the final partition, it is given an invalid range where the lower bound is greater than the upper bound . The expected output is an InvalidArgumentException thrown.

## Range.getLowerBound 
**1. negativeLowerBound()**
> This test case is the first partition, and is used to test the negative range of the lower bound given as an input. The expected output is the lower bound of the range given as an input.

**2. positiveLowerBound()**
> This test case is the second partition, and is used to test the positive range of the lower bound given as an input. The expected output is the lower bound of the range given as an input.

**3. getLowerBoundWithSameBounds()**
> This test case is the third partition, and is used to test the getter for the lower bound when the range is zero. The expected output is the lower bound of the range given as an input when the lower and upper bounds are the same.

.**4. illegalBounds()**
> This test case is the final partition, it is given an invalid range where the lower bound is greater than the upper bound . The expected output is an InvalidArgumentException thrown.


# 4 How the team work/effort was divided and managed

All team members developed test cases for this lab, as well as working on the writeups for this lab. We also incorporate the rigorous peer review process in which we reflected on each others code and write ups to ensure that they were of the highest quaity and ready for submission.

# 5 Difficulties encountered, challenges overcome, and lessons learned

One of the difficulties for Lucas was that he was intitially unable to get the JUnit and .jar files to run, as one of the files in the folder was corrupting the execution path. However after the quick correction of removing that file from the execution folder, the .jar files and the JUnit test files were able to run flawlessly.

Another difficulty was ensuring that the Eclipse enviroment was set up correctly so that it could correctly run the JUnit tests, once every team member was able to correctly set up the Eclipse enviroments, everything was able to run smoothly.

# 6 Comments/feedback on the lab itself

We throughly enjoyed this lab as it allowed us to develop our testing skills, something that is critical to the success of a software engineering professional.
