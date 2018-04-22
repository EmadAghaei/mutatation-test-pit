# mutation-test-pit

Execute the following commands to  run the mutation tests

    mvn clean install                              #clean and compile
    mvn test                                       #run jUnit
    mvn org.pitest:pitest-maven:mutationCoverage   #run PIT mutation tests


what is PIT? Why we should use Mutation tests like PIT? 
1.	mutations are automatically seeded into our code, then the Junits are run. If the tests fail then the mutation is killed, if your tests pass then the mutation survived. PIT runs the Junit tests against automatically modified versions of the code. When the code changes, it should produce different results and cause the unit tests to fail. If a unit test does not fail in this situation, it may indicate an issue with the test suite. Generally, the quality of the Junits can be evaluated from the percentage of mutations killed.
2. Line coverage measures only which code is executed by the Junit tests. It does not check that your tests are actually able to detect faults in the executed code. It is therefore only able to identify code that is definitely not tested


I used the default mutation operator. When I did PIT test the mutation coverage was around 65%, but the line coverage was too around 92%. The following picture shows the result.

The following is the console result of the running of PIT.
================================================================================
- Statistics
================================================================================
>> Generated 72 mutations Killed 46 (64%)
>> Ran 67 tests (0.93 tests per mutation)
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 16 Killed 8 (50%)
> KILLED 8 SURVIVED 8 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
>> Generated 7 Killed 6 (86%)
> KILLED 6 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
>> Generated 10 Killed 6 (60%)
> KILLED 6 SURVIVED 4 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.InvertNegsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator
>> Generated 6 Killed 5 (83%)
> KILLED 5 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 11 Killed 9 (82%)
> KILLED 9 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 2 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 21 Killed 11 (52%)
> KILLED 11 SURVIVED 8 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 2 
--------------------------------------------------------------------------------

I used the report generator of PIT. The below picture is a sample of the report.
 

Carefully analyzing the results show although lince coverage is high but the mutation coverage is not suitable. I have used the default mutator: ConditionalsBoundaryMutator (%), IncrementsMutator (%), VoidMethodCallMutator (%), InvertNegsMutator (%), ReturnValsMutator (%), MathMutator (%), NegateConditionalsMutator (%).  The results of mutator also show I should change some junits to kill more mutators. 


Strength of coverages


1.	Mutation coverage is more powerful than branch coverage.
2.	 Brach coverage is more powerful than statement coverage.
3.	100% mutation coverage appears to be better than 100% code coverage in practice.
4.	Mutation tests has more cost than line coverage. We should write more tests to cover all mutator to kill the code.
5.	Mutator for conditional like binderies, negate, and remove cover condition coverage.
6.	Edge coverage does not imply condition coverage, but condition coverage does imply edge coverage. By covering all conditions, will be guaranteed to cover every edge; but by covering every edge, you are not guaranteed to cover every condition. 
7.	For example,
int method (int a, int b)
{
    If (a < 0 || b < 0)
        return -1;
    else
        return +1;
}
Edge coverage: the edges here are "return -1", and "return +1"; in order to cover both of those edges, we need only two invocations: method (-1, 0); method (0, 0);
However, three conditions a < 0, a >= 0 && b < 0, and a >= 0 && b >= 0, so, you'd need something like the following to achieve complete condition coverage: function (-1, 0); function(0, -1); function(0, 0);
The key distinction in the definitions you posted is "and all possible values of the constituents of compound Boolean conditions are exercised at least once". Covering all the conditions will ensure that you will hit all the edges. But as you see, covering all the edges does not ensure that you will hit all the conditions.



