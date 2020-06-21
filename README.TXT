//
// author@ Jonathan Liao
// version 4.10.15
//
//

OVERVIEW
The time is December 1937 and Japan is at war with China. The Japanese army is raiding the city of Nanking,
and Chinese soldiers must defend the civilians that live in it for as long as possible.

The list of Civilian objects are stored in a Cilvian[] array in the Nanking object; that list will keep track of the inital population
of Nanking. Because the city is shut down, repopulation is currently at 0%. Inevitably, the Cilvilian count will
reach 0 due to prolonged casulaties. 

There are two types of combat units for both army: a soldier, and tank. Because the Chinese are far behind in technological 
sciences, their army is weaker but have greater numbers as they are the defenders at the start. The Chinese army's
objective is to defend the civilians as long as possible against the Japanese. 

The parameters of the game follow:
-The Chinese start out with a finite number of resources to build additional combat units. Civilians living in the city will
 regenerate the finite number of resources

-When all the cilvians in the cilvilian array are "true" for the "isDead" condition, the game is over. Nanking has fallen

-As more Chinese soldiers die, the higher the probability of a civilian dying after each Japanese raid (smaller Chinese army,
 the more Nanking is at risk)

-The Japanese army have an unlimited number of combat units, as they are the opposing team

-Soldiers are less expense than tanks, but have less health and have a lower chance of winning against a tank   

-Tanks are more expense than soldiers, but have more health while having a greater chance against a soldier

-Because of China's technological disadvantage, both the soldier and tank class success chances are slightly lower against 
 the Japanese combat units of the same class

CONSTRUCTING CLASSES
Two different super classes:
-combatUnit 
-civilianunit

The classes that extend the supers:
-combatUnit > chineseUnit  > ChineseSoldier
                           > chineseTank
                            
            > japaneseUnit > japaneseSoldier
                           > japaneseTank
                           
-Civilian unit
-unitTest

The unitTest class will construct the necessary armies, initialize the arrays that store both armies and civilian counts,
and call methods that engage the Japanese armies to raid Nanking. An infinate forloop will test out 