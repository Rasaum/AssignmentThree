# AssignmentThree

Outputs from running the code:

"C:\Users\Raissa Umwali\.jdks\openjdk-22.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.2.1\lib\idea_rt.jar=59327:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.2.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\Raissa Umwali\IdeaProjects\Assignment3\out\production\Assignment3;C:\Users\Raissa Umwali\IdeaProjects\Assignment3\lib\stdlib.jar" Main
java.lang.NumberFormatException: For input string: "6.94  6 . 94"
	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
	at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
	at java.base/java.lang.Double.parseDouble(Double.java:938)
	at Main.main(Main.java:72)


// Inserted a new product and this was the output:
Product inserted: Product ID: 4c69b61db1fc16e7013b43fc926e502d, Name: Safdie & Co. 35566.3T.01 Sheets, White 3 Sets, Category: Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets, Price: $49.38


// Tried a second insertion but inserted the same product (That already exists) and this was the output  
Product with ID 4c69b61db1fc16e7013b43fc926e502d already exists from CSV data.


// Search 1
Enter the Product ID you are looking for: 
4c69b61db1fc16e7013b43fc926e502d
Product found: Product ID: 4c69b61db1fc16e7013b43fc926e502d, Name: Safdie & Co. 35566.3T.01 Sheets, White 3 Sets, Category: Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets, Price: $49.38


// Search 2
Enter the Product ID you are looking for: 
66d49bbed043f5be260fa9f7fbff5957
Product found: Product ID: 66d49bbed043f5be260fa9f7fbff5957, Name: Electronic Snap Circuits Mini Kits Classpack, FM Radio, Motion Detector, Music Box (Set of 5), Category: Toys & Games | Learning & Education | Science Kits & Toys, Price: $99.95


// Search 3
Enter the Product ID you are looking for: 
2c55cae269aebf53838484b0d7dd931a
Product found: Product ID: 2c55cae269aebf53838484b0d7dd931a, Name: 3Doodler Create Flexy 3D Printing Filament Refill Bundle (X5 Pack, Over 1000'. of Extruded Plastics! - Innovate, Category: Toys & Games | Arts & Crafts | Craft Kits, Price: $34.99

Process finished with exit code 0
