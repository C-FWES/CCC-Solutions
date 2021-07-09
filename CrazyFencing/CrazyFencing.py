class Piece:
    def __init__(self, left_height, right_height, width):
        self.left_height = int(left_height)
        self.right_height = int(right_height)
        self.width = int(width)


n = int(input())
heights = input().split(" ")
widths = input().split(" ")
pieces = []
for i in range(n):
    pieces.append(Piece(heights[i], heights[i+1], widths[i]))
total_area = 0
for piece in pieces:
    left_height = piece.left_height
    right_height = piece.right_height
    width = piece.width
    area = width * ((left_height + right_height) / 2)
    total_area += area
print(total_area)