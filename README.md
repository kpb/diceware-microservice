## Yet Another Diceware Passphrase Generator

with microservices!

This project is an exercise in microservice development, but can be used to create secure passphrases.

### Diceware?

[Diceware][1] is a simple way of creating strong and easy to remember passphrases. A new passphrase is
generated by rolling a die and creating a series of five digit numbers which are then used to look up words
from a [Diceware word list][2]. The result is a somewhat easy to remember passphrase that is very easy to
remember. e.g., _cleft cam synod lacy canal wok_.

The [Diceware homepage][1] describes the method and includes some theory behind it, such as how many bits of
entropy the passphrases have and tons of other info.

The Diceware method encourages you to use a physical die. However, the [faq][3] states that you can use a
_good_ random number generator to create passphrases, such as Java's `SecureRandom` Class.

### Design

TODO Microservices. Spring boot. Spring Netflix OSS. Other goodness.

### Building and Running

You'll need a recent version of [Maven][4]

    $ mvn --version
    Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T05:57:37-06:00)

Clone the project

    $ git clone https://github.com/kpb/diceware-microservice.git
    
Build from the top

    $ cd diceware-microservice
    $ mvn clean install

#### CLI

Run the command line app and follow the instructions:

    $ java -jar diceware-cli/target/diceware-cli-0.0.1-SNAPSHOT.jar 
    Welcome to Diceware CLI!                                            

    How many words in the passphrase (default 5)? 4
    Generating a passphrase 4 words long...
    wc        za        nagy      ezra      
    63532     65261     43263     25135
    


[1]: http://world.std.com/~reinhold/diceware.html
[2]: http://world.std.com/%7Ereinhold/diceware.wordlist.asc
[3]: http://world.std.com/~reinhold/dicewarefaq.html#computer
[4]: https://maven.apache.org/
