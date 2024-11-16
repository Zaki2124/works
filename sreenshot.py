import pyautogui
import keyboard
import os

# root
target_directory = "地獄先生ぬ〜べ〜/1993"
os.makedirs(target_directory, exist_ok=True)


counter = 0

# screenshot area
def take_screenshot():
    global counter
    # area (x, y, width, height)
    x, y, width, height = 635, 90, 1625, 1235
    screenshot = pyautogui.screenshot(region=(x, y, width, height))
    screenshot.save(os.path.join(target_directory, f"screenshot{counter}.png"))
    counter += 1
    print(f"screenshot{counter-1}.png 保存しました")

# press z
keyboard.add_hotkey('z', take_screenshot)

# stop with ctrl+c
keyboard.wait('ctrl+c')
