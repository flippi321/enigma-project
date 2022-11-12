# Enigma-project
A digitalized version of the famous Enigma machine
Encrypts messages using 3 rotating drums, a reflector and a pinboard.

### Drum (Wheels)
A Drum, or wheel, will scramble an input letter into a new letter. Each machine contains 3 Wheels
There are three types of drums, which scrambles differently, and it is possible to combine different types of wheels.
After a letter has left the wheel section, then returned through the reflector the fist wheel will rotate.
When the first wheel has completed an entire roation, the middle wheel will rotate. And so on...

### Reflector
Will take an input letter and return a new letter, which will be on the opposite side of the alphabet
Important to note here is that the letters "," " "." and "!" have been added as well. So A will return !, since this is the last letter of the alphabet
Afterwards, it will be sent through the wheels a second time, but this time in the opposite direction

### Pinboard
Will connect two letters with each other, and exchange one with the other. This will mean that if you connect "a" with "n", Spain, would actually be read as Spnia.
It is theoretically possoble to connect all letters to another letter, but a single letter can only be connected to another letter.



## How it works
Let's say Carl and Cindy want to send an encrypted message between them. 
Carl Wants to send "Hello", but before he sends anything, he must set up his Enigma Machine

### 1: Set up Drums
Carl will need to chose what type of drums he wants to use, and in which order. Afterwards, he will need to choose the starting position of each wheel.
Let's say he want's to use the drum-combination A-B-C and set their position to 0-0-0.

### 2: Set up PinBoard
To make sure nobody will be able to decrypt his message, he wants to mask his word as something else. He therefore chooses to connect the following words:
H - C
L - T
O - E

### 3: Start Encryption
Now that the machine has been set up, Carl is ready to encrypt the message. He inputs the message "Hello" and the machine starts
The machine will go through the following process with every single letter. We are

#### Pinboard
Since H and C are connected, The input letter 'H' will be replaced with the letter 'C'

#### Drum 1
The letter "C" is send through the first drum, The letter "," is returned

#### Drum 2
The letter "," is send through the second drum, The letter "G" is returned

#### Drum 3
The letter "G" is send through the third drum, The letter "!" is returned

#### Reflector
The opposite of the letter "!" is returned. Since "!" is the last letter, "A" is returned
We now send this letter back through the drums

#### Drum 3
The letter "A" is send through the third drum, The letter "T" is returned

#### Drum 2
The letter "T" is send through the second drum, The letter "Z" is returned

#### Drum 1
The letter "Z" is send through the first drum, The letter "R" is returned

#### Rotation
The first drum rotates one position. This means the current positions of the wheels are 1-0-0.
If we would have sent 29 letters through before this one, the first drum would have rotated once, and the second wheel would also rotate, changing the position to 30-1-0, which we then change to 0-1-0 for simplicity

#### Return value
The letter R is added to a return String. When we have completed all the previous steps on all letters, the string is returned to Carl

### 3: Decryption
Carl sends his message "RAL!G" to Cindy. If she wants to Decrypt the message. She will just use the exact same method to decrypt. This means defining the drums and their start positions, and then running throught the encryption process. The only difference is that during decryption, we swich the letter the end, rather than the beginning
