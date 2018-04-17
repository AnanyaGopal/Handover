import matplotlib.pyplot as plt
import matplotlib.patches as patches
import math

fig1 = plt.figure()

ax1 = fig1.add_subplot(111, aspect='equal')

axes = plt.gca()
axes.set_xlim([-3,10])
axes.set_ylim([-3,10])
radius = 2
x = 0
y = 0

for itr in range (0,1):
    
    ax1.add_patch(
        patches.RegularPolygon(
            (x,y),
            6,
            radius,
            edgecolor = 'black'
        )
    )

distanceToside = math.sqrt(3)/4*radius*radius;
# Test cases


test = [
            [1,1], [0.0,1.2], [-2.3,0], [0.77,0.76], [1.0,1.2], [x+distanceToside, y], [x, y+distanceToside], [x,y-distanceToside], [x-distanceToside,y], [x-distanceToside+0.9,y],
            [x-distanceToside,y+0.9]
            
       ]
ax1.plot([x], [y], marker='o', markersize=3, color="red")
for d in range(0,11):
    #for ata in range(0,2):
    print(test[d])
    ax1.plot([test[d][0]], [test[d][1]], marker='o', markersize=3, color="black")


fig1.savefig('figure.png', dpi=90, bbox_inches='tight')
