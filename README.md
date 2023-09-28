# CSV-JavaParser
An CSV file of cities consisting of 2,000,000 lines is given. The program allows you to process and output sorted information in accordance with the three tasks below.

Link to the CSV file: https://drive.google.com/file/d/1DZxOgAX2ZhZrp0Z_Rs2ADx7TOH5lkAYV/view?usp=sharing
~136.5MB

After launching, the application waits for entering the path to the directory file or the "Exit" command to shut down.

After entering the path to the directory file, the application generates summary statistics:

1) Displays duplicate entries with the number of repetitions.
2) Displays how many in each city: 1, 2, 3, 4 and 5 storey buildings.
3) Shows the file processing time.
After the statistics are output, the application again waits for entering the path to the directory file or the shutdown command.

On average, the program processes the file in 3,627 seconds.

The strengths of the parser are:

Code quality and readability
The speed of the application

Program implementation: 
The parser uses the Maven system to add several classes from opencsv.
They are needed to convert information from an CSV file into the HashMap's
HashMap was chosen to sort information because it provides high speed of data insertion and deletion, at best in O(1).
<img width="751" alt="271392317-52705d9c-8a75-40e3-8cdf-921df51efb39" src="https://github.com/JUNIOR14501/CSV-JavaParser/assets/53307775/4bdf6a05-6a1c-4f4f-81b7-fd7b58f675b4">
