My fifth project was to create a model of a ‘wall’

I needed to draw a brick wall, of various shapes and colour patterns. 

The wall had to be made of pricks, 52 pixels wide and 15 pixels high 

The bottom left corner of the wall must always be at the coordinates 20,500

The wall is drawn brick by brick, from left to right, from the bottom to the top

The size of the wall is set by the user, but the wall cannot be more than 24 bricks wide and 31 bricks high 

If the user sets the multicolour option, every brick in the wall will be a different colour from a given set, otherwise, all bricks are red. 

If a user sets the decrease option, every row in the wall will be one brick shorter than the one below

If the user sets the symmetrical option, the wall will either be a rectangle (if decrease is off) or a pyramid (if decrease is on)

The user runs the application by setting a combination of these four options, then calling the method to draw the wall accordingly 

I also added an option to erase the wall. Every brick is in an ArrayList, so my eraseWall method, deletes the wall. 
