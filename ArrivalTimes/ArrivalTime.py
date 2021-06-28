def convertStartingTime(digits: str):
    startingTime = 0
    minutes = digits[3] + digits[4]
    if digits[0] == 0:
        hours = int(digits[1])*60
        startingTime = hours+int(minutes)
    else:
        hours = digits[0] + digits[1]
        startingTime = int(hours) * 60 + int(minutes)
    return startingTime

def isInRange(seven, ten, three, sevenPm, startTime):
    if startTime >= seven and startTime < ten:
        return True
    elif startTime >= three and startTime < sevenPm:
        return True
    else:
        return False

def convertToTimeFormat(finalTime: int):
    hours = str(int((finalTime/60) % 24))
    minutes = str(int(finalTime % 60))
    if int(hours) < 10:
        hours = "0" + hours
    if int(minutes) < 10:
        minutes = "0" + minutes
    time = hours + ":" + minutes
    return time

leaveTime = input()
sevenAm = 420
tenAm = 600
threePm = 900
sevenPm = 1140
startingTime = convertStartingTime(leaveTime)
originalTime = startingTime
timeIfSlowed = 240
accumulatedTime = 0
while timeIfSlowed > 0:
    if isInRange(sevenAm, tenAm, threePm, sevenPm, startingTime):
        timeIfSlowed -= 1
    else:
        timeIfSlowed -= 2
    accumulatedTime+=1
    startingTime+=1

finalTime = accumulatedTime+originalTime
arriveTime = convertToTimeFormat(finalTime)
print(arriveTime)


