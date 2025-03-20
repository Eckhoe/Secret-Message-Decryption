# Secret Message Decryption

This project was completed using two parts to decrypt both messages. Both programs come with encrpyted text files which would be time comsuming to decrpyt by hand. In order to gain access to the rules/outline for part B, messageA must be decrypted first.


### Part A (How it works & how to run):

In order to decrypt secretmessageA.txt.enc, the file is read and by using a key between 0 and 255, each byte read from the source file is xor'd with the next byte in the keystream. The resulting message will be inside of the Part A folder which will contain the resulting message output along with the original encrypted file. The key is not the same that was used to decrypt the message as the second part required submission which used part of my student id to encrpyt a message with my results.

### Part B

The second part uses a similar method of decrpytion. Instead of using 8 bits for the keystream, it uses 15. This increases the number of possible keys from 0 and 255, to 0 and 32767. Instead of just finding the key and xor'ing the bytes, the way of decrpyting is by using a the first 8 bits  then the remaining 7 + the 1st bit of the key. The method I used to find the solution was looping through all possible keys and checking for a key word. I figured since we'd have submission instructions, 'submission' would have a good chance of being in there. There are two constructors, one was used to find the proper key which is commented in the code, while the other constructor was used to help with submission of the work. This part will not include the final message since its a secret! If you want to find out what it says, feel free to run it! Once you find the message, feel free to change the readFile and writeFile to some .txt.enc file!

### How to run:
  1. Pull the code
  2. Make sure you've got Java and some ide installed. This is not an executable.
