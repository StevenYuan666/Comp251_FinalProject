# US Electoral System
This is totally a Knapsack problem!

I discovered that the US electoral system is quite complicated! Particularly, I found the following interesting information:

1. The American electorate were to decide between incumbent President Donald Trump and his Demo- cratic challenger, former Vice President Joe Biden.

2. The American people indirectly elect the president because even if each voter selects between Mr. Trump and Mr. Biden, they are actually voting for a representative of that candidate’s party known as an elector. The totals are not calculated nationwide, but the president is elected by an Electoral College selected state-by-state. The electoral college meets a few weeks after election day, to carry out the task of choosing the president (to vote for the candidate who got the majority of the votes in their own state). This system is usually known as a ‘winner-takes-all’ because the candidate with the highest number of votes in a state claims all the electoral votes of that state.

3. For the 2020 elections, it was guaranteed that every state had at least one delegate (the number of electoral votes of a state) and at least one registered voter.

4. For the 2020 elections, there are 538 delegates, but for our test cases we can have at most 2016 delegates.

5. In 2016, Mr. Trump beat Mrs. Clinton in Florida by a margin of just 2.2%, but that meant he claimed all 29 of Florida’s crucial electoral votes.

6. National polls were giving Mr. Biden an average lead of over 10%. However, is that enough, given the indirect way the United States elects its president?

7. There were over 100 million cast ballots in historic early voting, with millions more heading to the polls on Tuesday. Then, the electoral threshold (maximum number of allowed voters) was this year set to be 1 billion (109) cast ballots.

8. If there were a tie (either at the State or National level) between Mr. Trump and Mr. Biden, the US House of Representatives determines the president. As of November 2nd, 2020, Republicans were in the majority, with control of 26 state delegations, and as a consequence, Mr. Trump would be elected as the new president.

9. Based on the State Polls, Joe Biden was leading key states (the so-called battleground states including Michigan, Wisconsin, and Pennsylvania) that gave Mr. Trump his victory back in 2016.

10. Most State Polls were wrong about the 2016 presidential election. For example, the CBC’s Presidential Poll Tracker gave Mrs. Clinton a 3.4-point lead in the national polls over Mr. Trump on the election day. She was projected to win North Carolina, Florida, Michigan, Pennsylvania, and Wisconsin; however, Mr. Trump won all of these states and secured more than the 270 electoral college votes needed to win the White House.

At this point in my procrastination, I got interested in the polls that compiled information about the voting preferences per state. Particularly, for each State, I compiled the information regarding i) The expected number of people who are projected to vote for Mr. Biden, ii) The expected number of people who are projected to vote for Mr. Trump and iii) The number of people who have not made a voting decision yet. The technical description of the polls makes it clear that the numbers of the first two categories are not likely to change because they are votes from people with long-time roots in a particular political party. On the other hand, people in the third category are the ones who expressed no preference and did not lean towards either of the major parties. At this point (also of my procrastination), I realized that it would be great to have a very efficient algorithm to know the minimum number of people that Mr. Biden needs to convince in order to secure the presidency of the United States of America.

The idea is that I would provide you the files (some of them will be open cases and others will be blind cases) containing the following information:

• The first line of my file contains a single integer (i.e., num states) that represents the number of states taken into account by a poll.

• Following num states lines each contain four integers (separated by spaces) with the following infor- mation.

1. The number of delegates for a specific state.

2. The number of people who will vote for Mr. Biden in that state.

3. The number of people who will vote for Mr. Trump in that state.

4. The number of people who have not made a voting decision in that state yet.

For each provided file, I calculated the minimum number of people that Mr. Biden would have to convince to earn the US presidency. If it is not possible for Mr. Biden to win the election, you must output the integer −1.

![image](https://user-images.githubusercontent.com/68981504/148498811-3e66f2b4-108e-45c8-b5ba-ec2e64b9c86b.png)
