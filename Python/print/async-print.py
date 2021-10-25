import asyncio

async def asyncprint(string):
    await print(string)

asyncio.run(asyncprint("Hello World!"))