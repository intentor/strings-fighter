CharacterConfiguration = {

	getClanID = function() 
		return 2;
	end;

	getMainColor = function() 
		return "#FFFFFF";
	end;
	
	getSecondaryColor = function() 
		return "#B0C4DE";
	end;

	getJumpSize = function() 
		return 250;
	end;
	
	getJumpSpeed = function()
		return 8.5;
	end;	
	
	getPlayerSpeed = function()
		return 3;
	end;
	
	getLogoSprite = function()
		return "assets/sprites/characters/dobot/logo.png";
	end;
	
	getStartingSpriteDifference = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(35,0);
		return p;
	end;	
	
	getDyingSpriteDifference = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(35, 0);
		return p;
	end;	

    getPlayer1InitialPosition = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(20, 250);
		return p;
    end;
    
    getPlayer2InitialPosition = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(610, 250);
		return p;
    end;
        
    getSpriteInfoForStarting = function()
    	LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("starting");
		i:setSpriteDefPath("assets/sprites/characters/dobot/starting.def");
		i:addDuration(120);	
		
		return i;
    end;
    
	getSpriteInfoForDying = function()
    	LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDying();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("dying");
		i:setSpriteDefPath("assets/sprites/characters/dobot/dying.def");
		i:setHitboxesData(hbd);
		i:addDuration(65);
		
		return i;
    end;
    
    getSpriteInfoForStopped = function()
    	LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForStopped();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("stopped");
		i:setSpriteDefPath("assets/sprites/characters/dobot/stopped.def");
		i:setHitboxesData(hbd);
		i:addDuration(80);	
		
		return i;
    end;
    
    getSpriteInfoForWalking = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForWalking();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("walking");
		i:setSpriteDefPath("assets/sprites/characters/dobot/walking.def");
		i:setHitboxesData(hbd);
		i:addDuration(20);	
		
		return i;
    end;
    
 	getSpriteInfoForJumping = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForJumping();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("jumping");
		i:setSpriteDefPath("assets/sprites/characters/dobot/jumping.def");
		i:setHitboxesData(hbd);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(60);
		i:addDuration(100);
		i:addDuration(250);
		i:addDuration(300);
		i:addDuration(250);
		i:addDuration(200);
		i:addDuration(180);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(40);
		i:addDuration(30);
		i:addDuration(35);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(30);
		i:addDuration(50);
		
		return i;
    end;

    getSpriteInfoForDefending = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDefending();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("defending");
		i:setSpriteDefPath("assets/sprites/characters/dobot/defending.def");
		i:setHitboxesData(hbd);
		i:addDuration(10);	
		
		return i;
    end;    
	
    getSpriteInfoForDamage = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDamage();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("damage");
		i:setSpriteDefPath("assets/sprites/characters/dobot/damage.def");
		i:setHitboxesData(hbd);
		i:addDuration(5);
		i:addDuration(5);
		i:addDuration(15);
		i:addDuration(20);
		i:addDuration(25);
		i:addDuration(30);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);
		i:addDuration(35);	
		
		return i;
    end;
    
    getSpriteInfoForLowPunch = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForLowPunch();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("lp");
		i:setSpriteDefPath("assets/sprites/characters/dobot/low-punch.def");
		i:setHitboxesData(hbd);
		i:addDuration(20);	
		
		return i;
    end;
    
    getSpriteInfoForHighPunch = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForHighPunch();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("hp");
		i:setSpriteDefPath("assets/sprites/characters/dobot/high-punch.def");
		i:setHitboxesData(hbd);
		i:addDuration(35);	
		
		return i;
    end;
    
    getSpriteInfoForLowKick = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForLowKick();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("lk");
		i:setSpriteDefPath("assets/sprites/characters/dobot/low-kick.def");
		i:setHitboxesData(hbd);
		i:addDuration(20);	
		
		return i;
    end;
 
    getSpriteInfoForHighKick = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForHighKick();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("hk");
		i:setSpriteDefPath("assets/sprites/characters/dobot/high-kick.def");
		i:setHitboxesData(hbd);
		i:addDuration(35);	
		
		return i;
    end;
    
	getHitboxesForDying = function()
        LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData);
		
		i = hb:createFrame();
		i = hb:createFrame();		
		i = hb:createFrame();		
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		i = hb:createFrame();
		
		return hb;
    end;
    
    getHitboxesForStopped = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 58, 69, 39, 39, 3);
		hb:addHitbox(i, 52, 107, 50, 43, 2);
		hb:addHitbox(i, 48, 149, 57, 61, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 59, 42, 50, 3);
		hb:addHitbox(i, 51, 109, 57, 47, 2);
		hb:addHitbox(i, 49, 154, 62, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 59, 36, 47, 3);
		hb:addHitbox(i, 52, 106, 50, 51, 2);
		hb:addHitbox(i, 50, 156, 51, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 60, 36, 49, 3);
		hb:addHitbox(i, 52, 110, 50, 53, 2);
		hb:addHitbox(i, 50, 164, 52, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 96, 107, 0, 0, 3);
		hb:addHitbox(i, 53, 104, 48, 48, 2);
		hb:addHitbox(i, 50, 151, 51, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 58, 38, 53, 3);
		hb:addHitbox(i, 52, 109, 50, 47, 2);
		hb:addHitbox(i, 50, 156, 54, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 61, 40, 46, 3);
		hb:addHitbox(i, 48, 107, 55, 47, 2);
		hb:addHitbox(i, 47, 153, 57, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 63, 39, 52, 3);
		hb:addHitbox(i, 48, 114, 57, 45, 2);
		hb:addHitbox(i, 49, 157, 53, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 61, 40, 49, 3);
		hb:addHitbox(i, 50, 109, 56, 45, 2);
		hb:addHitbox(i, 49, 153, 55, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 63, 38, 52, 3);
		hb:addHitbox(i, 55, 114, 48, 49, 2);
		hb:addHitbox(i, 52, 164, 54, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 65, 41, 43, 3);
		hb:addHitbox(i, 52, 108, 50, 51, 2);
		hb:addHitbox(i, 49, 156, 53, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 54, 60, 43, 53, 3);
		hb:addHitbox(i, 49, 111, 55, 50, 2);
		hb:addHitbox(i, 46, 162, 57, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 61, 38, 47, 3);
		hb:addHitbox(i, 54, 106, 47, 43, 2);
		hb:addHitbox(i, 50, 150, 54, 58, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 56, 41, 53, 3);
		hb:addHitbox(i, 53, 108, 49, 54, 2);
		hb:addHitbox(i, 52, 164, 55, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 61, 39, 46, 3);
		hb:addHitbox(i, 52, 106, 50, 51, 2);
		hb:addHitbox(i, 51, 156, 49, 55, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 59, 38, 47, 3);
		hb:addHitbox(i, 48, 104, 54, 54, 2);
		hb:addHitbox(i, 49, 157, 52, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 58, 41, 48, 3);
		hb:addHitbox(i, 50, 105, 54, 48, 2);
		hb:addHitbox(i, 50, 153, 54, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 64, 41, 45, 3);
		hb:addHitbox(i, 52, 107, 51, 50, 2);
		hb:addHitbox(i, 49, 156, 54, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 62, 40, 44, 3);
		hb:addHitbox(i, 54, 105, 46, 53, 2);
		hb:addHitbox(i, 51, 156, 49, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 62, 39, 45, 3);
		hb:addHitbox(i, 53, 110, 49, 51, 2);
		hb:addHitbox(i, 50, 161, 50, 49, 1);

		return hb;
	end;
    
    getHitboxesForWalking = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 59, 65, 37, 42, 3);
		hb:addHitbox(i, 55, 108, 45, 43, 2);
		hb:addHitbox(i, 52, 152, 51, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 64, 63, 33, 47, 3);
		hb:addHitbox(i, 54, 108, 48, 44, 2);
		hb:addHitbox(i, 52, 152, 50, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 62, 40, 49, 3);
		hb:addHitbox(i, 55, 109, 48, 41, 2);
		hb:addHitbox(i, 52, 149, 52, 55, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 64, 42, 45, 3);
		hb:addHitbox(i, 57, 107, 46, 52, 2);
		hb:addHitbox(i, 55, 159, 52, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 66, 63, 35, 45, 3);
		hb:addHitbox(i, 55, 108, 49, 40, 2);
		hb:addHitbox(i, 52, 147, 52, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 61, 39, 48, 3);
		hb:addHitbox(i, 56, 106, 45, 50, 2);
		hb:addHitbox(i, 54, 156, 53, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 66, 36, 43, 3);
		hb:addHitbox(i, 54, 108, 49, 42, 2);
		hb:addHitbox(i, 52, 150, 52, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 62, 37, 46, 3);
		hb:addHitbox(i, 54, 107, 48, 45, 2);
		hb:addHitbox(i, 53, 153, 53, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 64, 41, 43, 3);
		hb:addHitbox(i, 58, 109, 43, 41, 2);
		hb:addHitbox(i, 52, 150, 52, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 64, 35, 48, 3);
		hb:addHitbox(i, 53, 114, 50, 43, 2);
		hb:addHitbox(i, 51, 155, 50, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 67, 36, 41, 3);
		hb:addHitbox(i, 54, 109, 46, 44, 2);
		hb:addHitbox(i, 48, 152, 55, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 62, 37, 46, 3);
		hb:addHitbox(i, 55, 108, 46, 51, 2);
		hb:addHitbox(i, 53, 158, 48, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 66, 38, 48, 3);
		hb:addHitbox(i, 53, 115, 51, 41, 2);
		hb:addHitbox(i, 51, 154, 50, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 60, 39, 47, 3);
		hb:addHitbox(i, 51, 104, 54, 51, 2);
		hb:addHitbox(i, 53, 155, 48, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 58, 36, 46, 3);
		hb:addHitbox(i, 55, 105, 47, 43, 2);
		hb:addHitbox(i, 51, 149, 51, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 60, 35, 46, 3);
		hb:addHitbox(i, 52, 107, 56, 47, 2);
		hb:addHitbox(i, 52, 155, 51, 44, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 61, 40, 44, 3);
		hb:addHitbox(i, 55, 107, 47, 37, 2);
		hb:addHitbox(i, 51, 144, 51, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 66, 40, 40, 3);
		hb:addHitbox(i, 53, 107, 51, 44, 2);
		hb:addHitbox(i, 50, 149, 52, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 65, 35, 43, 3);
		hb:addHitbox(i, 53, 106, 52, 45, 2);
		hb:addHitbox(i, 48, 150, 56, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 63, 40, 50, 3);
		hb:addHitbox(i, 50, 110, 54, 50, 2);
		hb:addHitbox(i, 50, 160, 55, 48, 1);

		return hb;
	end;
    
    getHitboxesForJumping = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 57, 63, 34, 41, 3);
		hb:addHitbox(i, 50, 102, 51, 53, 2);
		hb:addHitbox(i, 47, 154, 56, 55, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 61, 39, 45, 3);
		hb:addHitbox(i, 51, 107, 54, 55, 2);
		hb:addHitbox(i, 47, 162, 57, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 61, 36, 38, 3);
		hb:addHitbox(i, 51, 98, 50, 52, 2);
		hb:addHitbox(i, 46, 149, 57, 59, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 52, 37, 50, 3);
		hb:addHitbox(i, 49, 99, 54, 53, 2);
		hb:addHitbox(i, 48, 151, 54, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 52, 41, 43, 3);
		hb:addHitbox(i, 52, 94, 48, 46, 2);
		hb:addHitbox(i, 50, 142, 51, 65, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 46, 39, 42, 3);
		hb:addHitbox(i, 54, 89, 49, 54, 2);
		hb:addHitbox(i, 52, 140, 47, 64, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 44, 37, 39, 3);
		hb:addHitbox(i, 48, 83, 53, 47, 2);
		hb:addHitbox(i, 52, 131, 46, 76, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 54, 38, 42, 52, 3);
		hb:addHitbox(i, 51, 87, 52, 55, 2);
		hb:addHitbox(i, 52, 142, 49, 65, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 45, 35, 39, 3);
		hb:addHitbox(i, 48, 84, 57, 52, 2);
		hb:addHitbox(i, 51, 135, 51, 72, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 49, 38, 41, 3);
		hb:addHitbox(i, 52, 89, 51, 48, 2);
		hb:addHitbox(i, 50, 133, 52, 69, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 56, 37, 38, 3);
		hb:addHitbox(i, 50, 93, 54, 55, 2);
		hb:addHitbox(i, 49, 146, 56, 60, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 64, 36, 34, 3);
		hb:addHitbox(i, 53, 95, 48, 53, 2);
		hb:addHitbox(i, 49, 146, 52, 59, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 72, 39, 35, 3);
		hb:addHitbox(i, 53, 107, 47, 47, 2);
		hb:addHitbox(i, 49, 152, 55, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 82, 32, 25, 3);
		hb:addHitbox(i, 50, 106, 55, 31, 2);
		hb:addHitbox(i, 48, 138, 58, 69, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 86, 31, 27, 3);
		hb:addHitbox(i, 54, 113, 49, 32, 2);
		hb:addHitbox(i, 46, 142, 61, 62, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 92, 36, 29, 3);
		hb:addHitbox(i, 54, 118, 46, 24, 2);
		hb:addHitbox(i, 47, 140, 63, 75, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 95, 32, 21, 3);
		hb:addHitbox(i, 58, 114, 41, 31, 2);
		hb:addHitbox(i, 47, 141, 63, 63, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 95, 29, 23, 3);
		hb:addHitbox(i, 48, 115, 52, 21, 2);
		hb:addHitbox(i, 45, 136, 67, 70, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 87, 38, 37, 3);
		hb:addHitbox(i, 50, 123, 53, 37, 2);
		hb:addHitbox(i, 47, 160, 60, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 72, 38, 50, 3);
		hb:addHitbox(i, 49, 122, 59, 46, 2);
		hb:addHitbox(i, 47, 167, 63, 38, 1);

		return hb;
	end;
    
    getHitboxesForDefending = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 64, 62, 32, 52, 3);
		hb:addHitbox(i, 53, 114, 50, 45, 2);
		hb:addHitbox(i, 49, 158, 55, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 63, 36, 47, 3);
		hb:addHitbox(i, 57, 108, 45, 54, 2);
		hb:addHitbox(i, 53, 162, 48, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 62, 37, 138, 8);
		hb:addHitbox(i, 49, 125, 53, 51, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 57, 46, 154, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 53, 69, 39, 140, 8);
		hb:addHitbox(i, 92, 120, 12, 56, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 59, 41, 53, 8);
		hb:addHitbox(i, 50, 112, 56, 87, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 60, 36, 59, 8);
		hb:addHitbox(i, 49, 118, 60, 82, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 45, 62, 39, 56, 8);
		hb:addHitbox(i, 46, 117, 64, 50, 8);
		hb:addHitbox(i, 49, 167, 53, 41, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 44, 62, 40, 55, 8);
		hb:addHitbox(i, 43, 114, 67, 56, 8);
		hb:addHitbox(i, 47, 169, 58, 34, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 42, 63, 41, 54, 8);
		hb:addHitbox(i, 43, 114, 69, 57, 8);
		hb:addHitbox(i, 44, 172, 61, 35, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 44, 65, 41, 49, 8);
		hb:addHitbox(i, 43, 113, 69, 58, 8);
		hb:addHitbox(i, 44, 169, 61, 31, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 39, 65, 46, 52, 8);
		hb:addHitbox(i, 39, 116, 73, 53, 8);
		hb:addHitbox(i, 45, 170, 59, 30, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 43, 63, 40, 56, 8);
		hb:addHitbox(i, 42, 117, 69, 57, 8);
		hb:addHitbox(i, 39, 172, 64, 29, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 43, 61, 43, 59, 8);
		hb:addHitbox(i, 42, 117, 67, 57, 8);
		hb:addHitbox(i, 39, 173, 65, 34, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 46, 61, 42, 58, 8);
		hb:addHitbox(i, 42, 118, 67, 52, 8);
		hb:addHitbox(i, 43, 171, 62, 26, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 60, 41, 61, 8);
		hb:addHitbox(i, 50, 120, 57, 56, 8);
		hb:addHitbox(i, 42, 176, 63, 22, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 53, 60, 40, 65, 8);
		hb:addHitbox(i, 51, 124, 52, 73, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 61, 38, 65, 8);
		hb:addHitbox(i, 50, 122, 51, 77, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 61, 37, 51, 3);
		hb:addHitbox(i, 48, 108, 58, 56, 2);
		hb:addHitbox(i, 48, 163, 55, 38, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 64, 41, 47, 3);
		hb:addHitbox(i, 46, 111, 56, 52, 2);
		hb:addHitbox(i, 48, 163, 57, 38, 1);

		return hb;
	end;    
	
    getHitboxesForDamage = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 41, 65, 67, 144, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 51, 65, 48, 144, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 38, 67, 64, 144, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 34, 74, 70, 135, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 29, 71, 68, 140, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 32, 71, 64, 140, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 19, 68, 75, 142, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 31, 64, 62, 142, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 29, 63, 62, 142, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 28, 59, 66, 145, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 30, 64, 65, 143, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 32, 59, 64, 149, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 32, 62, 60, 144, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 39, 56, 60, 150, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 31, 60, 70, 153, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 33, 68, 67, 142, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 41, 62, 61, 150, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 35, 61, 67, 147, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 42, 65, 62, 143, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 37, 58, 65, 155, 0);

		return hb;
	end;
    
    getHitboxesForLowPunch = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 59, 66, 38, 44, 3);
		hb:addHitbox(i, 50, 110, 53, 45, 2);
		hb:addHitbox(i, 49, 154, 54, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 68, 41, 45, 3);
		hb:addHitbox(i, 51, 113, 53, 46, 2);
		hb:addHitbox(i, 48, 157, 54, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 54, 67, 43, 47, 3);
		hb:addHitbox(i, 49, 113, 54, 54, 2);
		hb:addHitbox(i, 50, 166, 54, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 70, 40, 48, 2);
		hb:addHitbox(i, 54, 118, 47, 92, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 67, 37, 51, 2);
		hb:addHitbox(i, 49, 119, 52, 92, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 67, 43, 49, 2);
		hb:addHitbox(i, 47, 116, 56, 96, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 42, 123, 47, 46, 4);
		hb:addHitbox(i, 58, 70, 37, 52, 2);
		hb:addHitbox(i, 44, 169, 58, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 125, 67, 44, 4);
		hb:addHitbox(i, 61, 77, 32, 47, 2);
		hb:addHitbox(i, 44, 169, 62, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 127, 72, 45, 4);
		hb:addHitbox(i, 62, 78, 29, 47, 2);
		hb:addHitbox(i, 49, 174, 57, 32, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 129, 78, 42, 4);
		hb:addHitbox(i, 63, 83, 27, 43, 2);
		hb:addHitbox(i, 43, 173, 62, 31, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 131, 70, 40, 4);
		hb:addHitbox(i, 60, 78, 30, 51, 2);
		hb:addHitbox(i, 48, 171, 57, 36, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 129, 70, 43, 4);
		hb:addHitbox(i, 60, 79, 32, 45, 2);
		hb:addHitbox(i, 43, 170, 66, 35, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 52, 127, 69, 45, 4);
		hb:addHitbox(i, 63, 78, 28, 47, 2);
		hb:addHitbox(i, 48, 176, 54, 33, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 124, 49, 49, 4);
		hb:addHitbox(i, 64, 74, 28, 48, 2);
		hb:addHitbox(i, 47, 176, 57, 30, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 71, 33, 48, 2);
		hb:addHitbox(i, 47, 118, 53, 93, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 72, 37, 46, 2);
		hb:addHitbox(i, 46, 119, 55, 91, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 67, 32, 49, 2);
		hb:addHitbox(i, 50, 115, 49, 97, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 65, 37, 42, 3);
		hb:addHitbox(i, 50, 104, 53, 49, 2);
		hb:addHitbox(i, 52, 153, 55, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 63, 39, 50, 3);
		hb:addHitbox(i, 49, 111, 54, 45, 2);
		hb:addHitbox(i, 47, 156, 60, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 68, 34, 39, 3);
		hb:addHitbox(i, 55, 107, 44, 47, 2);
		hb:addHitbox(i, 49, 155, 55, 54, 1);

		return hb;
	end;
    
    getHitboxesForHighPunch = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 57, 61, 38, 52, 3);
		hb:addHitbox(i, 41, 113, 65, 49, 2);
		hb:addHitbox(i, 40, 162, 66, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 69, 40, 41, 3);
		hb:addHitbox(i, 50, 110, 57, 45, 2);
		hb:addHitbox(i, 48, 155, 57, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 65, 38, 45, 3);
		hb:addHitbox(i, 47, 110, 58, 53, 2);
		hb:addHitbox(i, 50, 161, 55, 44, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 69, 41, 37, 3);
		hb:addHitbox(i, 43, 105, 61, 50, 2);
		hb:addHitbox(i, 47, 155, 57, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 46, 69, 43, 38, 3);
		hb:addHitbox(i, 45, 108, 58, 49, 2);
		hb:addHitbox(i, 48, 156, 56, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 12, 121, 41, 68, 5);
		hb:addHitbox(i, 41, 68, 41, 37, 3);
		hb:addHitbox(i, 52, 106, 46, 48, 2);
		hb:addHitbox(i, 51, 152, 55, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 37, 119, 38, 55, 5);
		hb:addHitbox(i, 43, 72, 27, 40, 3);
		hb:addHitbox(i, 49, 174, 51, 38, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 103, 47, 46, 5);
		hb:addHitbox(i, 48, 66, 25, 34, 3);
		hb:addHitbox(i, 48, 151, 59, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 91, 75, 47, 5);
		hb:addHitbox(i, 46, 54, 32, 39, 3);
		hb:addHitbox(i, 48, 140, 55, 65, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 67, 93, 68, 44, 5);
		hb:addHitbox(i, 41, 64, 43, 27, 3);
		hb:addHitbox(i, 50, 138, 56, 63, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 95, 58, 39, 5);
		hb:addHitbox(i, 44, 61, 41, 33, 3);
		hb:addHitbox(i, 50, 137, 53, 65, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 64, 93, 68, 43, 5);
		hb:addHitbox(i, 44, 64, 37, 27, 3);
		hb:addHitbox(i, 48, 138, 55, 73, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 53, 100, 63, 41, 5);
		hb:addHitbox(i, 45, 60, 38, 42, 3);
		hb:addHitbox(i, 46, 148, 57, 58, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 65, 90, 32, 60, 5);
		hb:addHitbox(i, 44, 58, 26, 46, 3);
		hb:addHitbox(i, 46, 142, 57, 67, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 100, 30, 60, 5);
		hb:addHitbox(i, 46, 55, 22, 44, 3);
		hb:addHitbox(i, 42, 162, 65, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 42, 112, 28, 61, 5);
		hb:addHitbox(i, 46, 64, 27, 46, 3);
		hb:addHitbox(i, 41, 170, 66, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 54, 65, 33, 43, 3);
		hb:addHitbox(i, 51, 109, 48, 52, 2);
		hb:addHitbox(i, 48, 161, 58, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 65, 37, 42, 3);
		hb:addHitbox(i, 44, 110, 62, 51, 2);
		hb:addHitbox(i, 43, 159, 62, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 64, 42, 42, 3);
		hb:addHitbox(i, 51, 106, 51, 55, 2);
		hb:addHitbox(i, 49, 157, 55, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 63, 37, 47, 3);
		hb:addHitbox(i, 52, 111, 53, 50, 2);
		hb:addHitbox(i, 49, 161, 54, 43, 1);

		return hb;
	end;
    
    getHitboxesForLowKick = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 56, 71, 40, 41, 3);
		hb:addHitbox(i, 46, 110, 57, 43, 2);
		hb:addHitbox(i, 48, 152, 54, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 68, 34, 43, 3);
		hb:addHitbox(i, 52, 107, 49, 56, 2);
		hb:addHitbox(i, 50, 162, 51, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 51, 174, 29, 38, 6);
		hb:addHitbox(i, 59, 66, 30, 43, 2);
		hb:addHitbox(i, 56, 122, 42, 33, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 52, 172, 49, 37, 6);
		hb:addHitbox(i, 53, 71, 37, 39, 2);
		hb:addHitbox(i, 49, 121, 51, 33, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 51, 176, 51, 34, 6);
		hb:addHitbox(i, 55, 75, 36, 37, 2);
		hb:addHitbox(i, 53, 123, 54, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 51, 171, 57, 25, 6);
		hb:addHitbox(i, 57, 70, 30, 41, 2);
		hb:addHitbox(i, 53, 117, 49, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 54, 170, 58, 26, 6);
		hb:addHitbox(i, 55, 68, 32, 44, 2);
		hb:addHitbox(i, 57, 118, 40, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 47, 160, 74, 33, 6);
		hb:addHitbox(i, 53, 71, 29, 44, 2);
		hb:addHitbox(i, 51, 123, 50, 35, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 46, 160, 81, 41, 6);
		hb:addHitbox(i, 50, 68, 31, 47, 2);
		hb:addHitbox(i, 52, 119, 46, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 42, 159, 89, 43, 6);
		hb:addHitbox(i, 50, 73, 34, 45, 2);
		hb:addHitbox(i, 51, 123, 47, 30, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 49, 160, 80, 45, 6);
		hb:addHitbox(i, 54, 68, 27, 46, 2);
		hb:addHitbox(i, 50, 117, 48, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 44, 160, 85, 41, 6);
		hb:addHitbox(i, 53, 70, 32, 46, 2);
		hb:addHitbox(i, 48, 119, 51, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 46, 161, 77, 43, 6);
		hb:addHitbox(i, 56, 70, 29, 43, 2);
		hb:addHitbox(i, 50, 112, 51, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 44, 163, 79, 39, 6);
		hb:addHitbox(i, 52, 70, 37, 48, 2);
		hb:addHitbox(i, 52, 121, 47, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 165, 65, 41, 6);
		hb:addHitbox(i, 55, 68, 30, 48, 2);
		hb:addHitbox(i, 52, 121, 47, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 166, 60, 35, 6);
		hb:addHitbox(i, 56, 70, 36, 40, 2);
		hb:addHitbox(i, 57, 113, 41, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 52, 163, 52, 38, 6);
		hb:addHitbox(i, 55, 65, 37, 46, 2);
		hb:addHitbox(i, 54, 115, 49, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 66, 36, 45, 3);
		hb:addHitbox(i, 50, 110, 52, 48, 2);
		hb:addHitbox(i, 50, 158, 60, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 61, 39, 47, 3);
		hb:addHitbox(i, 51, 108, 53, 53, 2);
		hb:addHitbox(i, 101, 209, 0, 0, 1);
		hb:addHitbox(i, 49, 160, 58, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 68, 40, 47, 3);
		hb:addHitbox(i, 53, 114, 51, 38, 2);
		hb:addHitbox(i, 47, 150, 57, 58, 1);

		return hb;
	end;
 
    getHitboxesForHighKick = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 61, 72, 35, 38, 3);
		hb:addHitbox(i, 53, 108, 51, 52, 2);
		hb:addHitbox(i, 51, 158, 51, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 112, 43, 49, 8);
		hb:addHitbox(i, 46, 161, 63, 52, 7);
		hb:addHitbox(i, 65, 66, 31, 46, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 66, 120, 32, 50, 8);
		hb:addHitbox(i, 61, 170, 48, 42, 7);
		hb:addHitbox(i, 75, 70, 25, 53, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 122, 28, 41, 8);
		hb:addHitbox(i, 61, 164, 49, 38, 7);
		hb:addHitbox(i, 77, 83, 27, 39, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 134, 28, 33, 8);
		hb:addHitbox(i, 62, 166, 54, 29, 7);
		hb:addHitbox(i, 85, 88, 49, 49, 5);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 118, 26, 40, 8);
		hb:addHitbox(i, 60, 158, 61, 33, 7);
		hb:addHitbox(i, 77, 79, 24, 42, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 64, 145, 68, 29, 7);
		hb:addHitbox(i, 66, 64, 19, 56, 3);
		hb:addHitbox(i, 64, 120, 39, 25, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 128, 53, 34, 7);
		hb:addHitbox(i, 40, 68, 35, 60, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 121, 58, 32, 7);
		hb:addHitbox(i, 21, 78, 50, 42, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 82, 107, 52, 48, 7);
		hb:addHitbox(i, 21, 81, 44, 33, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 80, 112, 51, 43, 7);
		hb:addHitbox(i, 20, 83, 45, 36, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 84, 126, 44, 32, 7);
		hb:addHitbox(i, 23, 80, 46, 43, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 134, 62, 27, 7);
		hb:addHitbox(i, 29, 77, 43, 46, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 60, 140, 69, 34, 8);
		hb:addHitbox(i, 38, 77, 40, 40, 3);
		hb:addHitbox(i, 39, 115, 54, 27, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 156, 73, 29, 8);
		hb:addHitbox(i, 43, 73, 43, 47, 3);
		hb:addHitbox(i, 40, 121, 64, 32, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 157, 62, 41, 8);
		hb:addHitbox(i, 46, 72, 42, 45, 3);
		hb:addHitbox(i, 41, 117, 65, 38, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 47, 165, 68, 44, 8);
		hb:addHitbox(i, 51, 66, 43, 50, 3);
		hb:addHitbox(i, 46, 115, 60, 51, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 63, 38, 43, 3);
		hb:addHitbox(i, 44, 105, 64, 46, 2);
		hb:addHitbox(i, 44, 151, 74, 60, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 65, 38, 48, 3);
		hb:addHitbox(i, 51, 110, 53, 46, 2);
		hb:addHitbox(i, 48, 157, 61, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 70, 36, 39, 3);
		hb:addHitbox(i, 49, 107, 58, 46, 2);
		hb:addHitbox(i, 45, 153, 65, 55, 1);

		return hb;
	end;
}