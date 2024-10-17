a tournament simulator application

#### Method for simulating fights

the method i chose to simulate fights is to create a "number-line" based event simulator

The number-line method is one which would include different intervals on a 1-100 number line
(1-100 can match probabilities) where each interval would represent a different result, and the
probability of each type of event determines how large the interval is. 

Each fight has a number line that is kept through each round, which contains 6 intervals:
    - Fighter 1 wins by KO
    - Fighter 2 wins by KO
    - Fighter 1 wins by submission
    - Fighter 2 wins by submission
    - Fighter 1 wins round (either move to next round or go to decision)
    - Fighter 2 wins round (same as above)

After each round, if the random number falls within one of the first 4 intervals, the fight is over
because one fighter was finished. If it lands on the win round, it goes to the next round where the
simulation repeats. If the final round is reached, then the decision is simply whoever won more rounds.
Each interval is based on the fighters stats, meaning a fighter with better striking would have a higher
KO interval than one with a good ground game (who would have a better submission interval). The decision
intervals are decided by the fighters total stats after the other 4 are calculated in order to reach [0, 100]

Each fighter has the following stat attributes. Each of which is a grade from 1-100:
    - Striking Ability
    - Striking Defense
    - Grappling Ability
    - Grappling Defense
    - Skill Level

The Abilities determine the likelihood of finishing the fight, the defense acts as a negative multiplier:
    If fighter1.strikingAbility > fighter2.strikingDefense, fighter1's KO chance is even higher

Skill Level determines what percent of the remaining interval is given to either fighter for winning the round
    If fighter1.skillLevel > fighter2.skillLevel, fighter1's winRound interval is greater by the amount
    proportional to the difference