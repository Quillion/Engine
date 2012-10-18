Objects so far

QConstants:
    Has constant values that can be used.

QBox:
    A simple box,
    has x and y and width and hegith.
    Can call draw or drawBox to see what it looks like

QPlatform:
    Extension of QBox,
    contains both and image and color.
    If image is not loaded then draw function will draw whatever you set color to,
    default color is black

QBBox:
    Extension of QBox. A box with a bounding box
    Contains offsets which can be used for more realistic like collision detection.

QBPlatform:
    Extension of QBBox. Contains image only.
    Draw method will draw the image to canvas.
    Please make sure to load the image beforehand.

QBMBox:
    Extension of QBBox. A Bounding box which has vectors.
    Pretty useless by itself.

QBMControls:
    Extension of QBMBox. Introduces controls for the movement bounding box.



Others:

Main:
    Contains brains of the game, don't touch it if you can help it.

Game:
    Contains functions which have to be populated for the game to work.
    Those functions are being called by Main. Much more simpler to read and understand.
