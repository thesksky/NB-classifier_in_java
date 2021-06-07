Data:

A scraped crowdsourcing dataset from Kaggle with the final column stating whether the project was funded or not. 

378661 rows.


Features: 

ID, name, category, main_category, currency, deadline, goal, launched, days_open, pledged, backers, country, usd pledged, usd_pledged_real, usd_goal_real, state, stateNY


Sample values: 

1E+09, Support Solar Roasted Coffee & Green Energy!  SolarCoffee.co, Food, Food, USD, 21-12-14, 1000, 01-12-14 18:30, 19.23, 1205, 16, US, 1205, 1205, 1000, successful, Yes

1E+09, Where is Hank?, Narrative Film, Film & Video, USD, 26-02-13, 45000, 12-01-13 0:20, 44.99, 220, 3, US, 220, 220, 45000, failed, No



Goal:

Apply a Naive Bayes model to predict whether a project would be funded.
Naive Bayes is a supervised machine learning algorithm which are frequently used for classification. 
These algorithms are trained with input features and categorical outputs to predict (yes/no, spam/not spam). The algorithm is also well-known for multi-class prediction.

It’s called naïve because it assumes that the input features are independent of each other which frequently is not true, but changing one feature will not impact the others. It is rather fast and often achieves a higher success rate than other algorithms.


Technology:

Java (Eclipse), 
Machine learning library from Weka 3.8 (https://sourceforge.net/projects/weka). It uses AARF files but can read in CSV files and convert them. It treats the last column as the target.

The ID number and the Title features were removed as the IDs are ordinal numbers and may impact the prediction.


Sample output:

'Mobile Games',Games,AUD,21-06-15,1000,'22-05-15 12:54',29.46,0,0,AU,0,0,765.64,failed,No

'Film & Video','Film & Video',USD,02-07-14,500,'11-06-14 3:25', 20.86, 500, 3, US, 500, 500, 500, successful, Yes

…
Correctly Classified Instances      376673               99.475  %

Incorrectly Classified Instances      1988                0.525  %

Kappa statistic                          0.9886

Mean absolute error                      0.0054

Root mean squared error                  0.0683

Relative absolute error                  1.1793 %

Root relative squared error             14.2146 %

Total Number of Instances           378661


