import matplotlib.pyplot as plt
import matplotlib.patches as patches
import math

fig1 = plt.figure()
fig2 = plt.figure()



ax1 = fig1.add_subplot(111, aspect='equal')

x = 0
y = 0
for itr in range(0, 3):
	print x
	ax1.add_patch(
	    patches.RegularPolygon(
		(x, y),     # (x,y)
		6,              # number of vertices
		0.1,
		color='red'            # radius
	    )
	)
	y=y+0.3

y = 0.15
newx = math.sqrt(3)*0.5*0.1
print newx

for itr in range(0, 3):
	
	ax1.add_patch(
	    patches.RegularPolygon(
		(newx, y),     # (x,y)
		6,              # number of vertices
		0.1,
		color='blue'            # radius
	    )
	)
	y=y+0.3

'''
y = 0
newxx = math.sqrt(3)*0.5*newx


for itr in range(0, 3):
	
	ax1.add_patch(
	    patches.RegularPolygon(
		(newxx, y),     # (x,y)
		6,              # number of vertices
		0.1,
		color='red'            # radius
	    )
	)
	y=y+0.3
'''	
fig1.savefig('reg-polygon1d.png', dpi=90, bbox_inches='tight')
