CharacterConfiguration = {

	getClanID = function() 
		return 1;
	end;

	getMainColor = function() 
		return "#CD853F";
	end;
	
	getSecondaryColor = function() 
		return "#FF0000";
	end;

	getJumpSize = function() 
		return 200;
	end;
	
	getJumpSpeed = function()
		return 8.5;
	end;	
	
	getPlayerSpeed = function()
		return 4;
	end;
	
	getLogoSprite = function()
		return "assets/sprites/characters/ankh/logo.png";
	end;
	
	getStartingSpriteDifference = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(0,130);
		return p;
	end;	
	
	getDyingSpriteDifference = function()
    	Point = luajava.bindClass("java.awt.Point");
		p = luajava.new(Point);
		
		p:setLocation(0,0);
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
		i:setSpriteDefPath("assets/sprites/characters/ankh/starting.def");
		i:addDuration(120);	
		
		return i;
    end;
    
	getSpriteInfoForDying = function()
    	LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDying();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("dying");
		i:setSpriteDefPath("assets/sprites/characters/ankh/dying.def");
		i:setHitboxesData(hbd);
		i:addDuration(65);	
		
		return i;
    end;
    
    getSpriteInfoForStopped = function()
    	LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForStopped();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("stopped");
		i:setSpriteDefPath("assets/sprites/characters/ankh/stopped.def");
		i:setHitboxesData(hbd);
		i:addDuration(80);	
		
		return i;
    end;
    
    getSpriteInfoForWalking = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForWalking();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("walking");
		i:setSpriteDefPath("assets/sprites/characters/ankh/walking.def");
		i:setHitboxesData(hbd);
		i:addDuration(40);	
		
		return i;
    end;
    
    getSpriteInfoForJumping = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForJumping();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("jumping");
		i:setSpriteDefPath("assets/sprites/characters/ankh/jumping.def");
		i:setHitboxesData(hbd);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(60);
		i:addDuration(50);
		i:addDuration(50);
		i:addDuration(200);
		i:addDuration(450);
		i:addDuration(400);
		i:addDuration(200);
		i:addDuration(40);
		i:addDuration(40);
		i:addDuration(40);
		i:addDuration(40);
		i:addDuration(90);
		i:addDuration(70);
		i:addDuration(30);
		i:addDuration(30);
		i:addDuration(30);
		
		return i;
    end;
    
    getSpriteInfoForDefending = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDefending();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("defending");
		i:setSpriteDefPath("assets/sprites/characters/ankh/defending.def");
		i:setHitboxesData(hbd);
		i:addDuration(10);	
		
		return i;
    end;    
	
    getSpriteInfoForDamage = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForDamage();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("damage");
		i:setSpriteDefPath("assets/sprites/characters/ankh/damage.def");
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
		i:setSpriteDefPath("assets/sprites/characters/ankh/low-punch.def");
		i:setHitboxesData(hbd);
		i:addDuration(20);	
		
		return i;
    end;
    
    getSpriteInfoForHighPunch = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForHighPunch();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("hp");
		i:setSpriteDefPath("assets/sprites/characters/ankh/high-punch.def");
		i:setHitboxesData(hbd);
		i:addDuration(35);	
		
		return i;
    end;
    
    getSpriteInfoForLowKick = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForLowKick();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("lk");
		i:setSpriteDefPath("assets/sprites/characters/ankh/low-kick.def");
		i:setHitboxesData(hbd);
		i:addDuration(20);	
		
		return i;
    end;
 
    getSpriteInfoForHighKick = function()
        LuaPackedSpriteInfo = luajava.bindClass("core.scripts.lua.LuaPackedSpriteInfo");
		hbd = CharacterConfiguration:getHitboxesForHighKick();
		i = luajava.new(LuaPackedSpriteInfo);
		
		i:setSpriteItemsName("hk");
		i:setSpriteDefPath("assets/sprites/characters/ankh/high-kick.def");
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
		hb:addHitbox(i, 77, 72, 30, 52, 3);
		hb:addHitbox(i, 72, 121, 34, 43, 2);
		hb:addHitbox(i, 69, 164, 53, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 66, 39, 44, 3);
		hb:addHitbox(i, 69, 109, 43, 44, 2);
		hb:addHitbox(i, 67, 153, 57, 55, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 68, 31, 54, 3);
		hb:addHitbox(i, 69, 122, 39, 43, 2);
		hb:addHitbox(i, 66, 166, 61, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 68, 33, 42, 3);
		hb:addHitbox(i, 70, 110, 38, 46, 2);
		hb:addHitbox(i, 59, 156, 67, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 72, 32, 46, 3);
		hb:addHitbox(i, 69, 158, 56, 51, 3);
		hb:addHitbox(i, 69, 118, 41, 41, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 69, 35, 48, 3);
		hb:addHitbox(i, 65, 116, 45, 44, 2);
		hb:addHitbox(i, 64, 158, 63, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 67, 39, 45, 3);
		hb:addHitbox(i, 70, 111, 45, 45, 2);
		hb:addHitbox(i, 69, 155, 62, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 64, 34, 51, 3);
		hb:addHitbox(i, 68, 117, 40, 44, 2);
		hb:addHitbox(i, 61, 158, 67, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 64, 30, 52, 3);
		hb:addHitbox(i, 71, 115, 39, 40, 2);
		hb:addHitbox(i, 72, 156, 53, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 66, 32, 49, 3);
		hb:addHitbox(i, 71, 113, 36, 46, 2);
		hb:addHitbox(i, 66, 154, 57, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 66, 30, 45, 3);
		hb:addHitbox(i, 71, 112, 37, 45, 2);
		hb:addHitbox(i, 67, 156, 58, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 67, 32, 48, 3);
		hb:addHitbox(i, 66, 115, 42, 45, 2);
		hb:addHitbox(i, 65, 159, 63, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 70, 33, 40, 3);
		hb:addHitbox(i, 69, 109, 42, 47, 2);
		hb:addHitbox(i, 70, 156, 60, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 74, 35, 43, 3);
		hb:addHitbox(i, 72, 118, 38, 44, 2);
		hb:addHitbox(i, 65, 162, 64, 44, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 68, 34, 51, 3);
		hb:addHitbox(i, 68, 118, 44, 41, 2);
		hb:addHitbox(i, 66, 158, 63, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 67, 32, 52, 3);
		hb:addHitbox(i, 70, 118, 41, 47, 2);
		hb:addHitbox(i, 62, 164, 66, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 66, 37, 47, 3);
		hb:addHitbox(i, 68, 113, 45, 43, 2);
		hb:addHitbox(i, 64, 155, 63, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 68, 31, 47, 3);
		hb:addHitbox(i, 71, 115, 38, 49, 2);
		hb:addHitbox(i, 65, 161, 62, 45, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 65, 37, 50, 3);
		hb:addHitbox(i, 67, 113, 46, 47, 2);
		hb:addHitbox(i, 66, 159, 63, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 70, 28, 47, 3);
		hb:addHitbox(i, 69, 115, 41, 45, 2);
		hb:addHitbox(i, 69, 160, 59, 49, 1);

		return hb;
	end;
    
    getHitboxesForWalking = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 75, 71, 33, 47, 3);
		hb:addHitbox(i, 72, 116, 35, 43, 2);
		hb:addHitbox(i, 67, 159, 61, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 68, 30, 52, 3);
		hb:addHitbox(i, 71, 119, 36, 43, 2);
		hb:addHitbox(i, 71, 162, 55, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 80, 69, 27, 51, 3);
		hb:addHitbox(i, 71, 119, 37, 41, 2);
		hb:addHitbox(i, 65, 159, 59, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 68, 34, 52, 3);
		hb:addHitbox(i, 72, 122, 36, 40, 2);
		hb:addHitbox(i, 68, 160, 55, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 65, 30, 40, 3);
		hb:addHitbox(i, 67, 104, 41, 55, 2);
		hb:addHitbox(i, 70, 158, 54, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 73, 37, 42, 3);
		hb:addHitbox(i, 72, 113, 34, 50, 2);
		hb:addHitbox(i, 71, 160, 55, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 79, 66, 31, 49, 3);
		hb:addHitbox(i, 72, 114, 36, 43, 2);
		hb:addHitbox(i, 70, 157, 52, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 65, 33, 55, 3);
		hb:addHitbox(i, 72, 117, 35, 45, 2);
		hb:addHitbox(i, 67, 160, 55, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 65, 32, 41, 3);
		hb:addHitbox(i, 70, 107, 38, 48, 2);
		hb:addHitbox(i, 67, 154, 55, 54, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 71, 66, 36, 50, 3);
		hb:addHitbox(i, 68, 116, 40, 43, 2);
		hb:addHitbox(i, 69, 159, 61, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 67, 32, 45, 3);
		hb:addHitbox(i, 71, 112, 38, 46, 2);
		hb:addHitbox(i, 68, 156, 60, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 65, 33, 49, 3);
		hb:addHitbox(i, 71, 116, 40, 44, 2);
		hb:addHitbox(i, 68, 159, 63, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 65, 32, 50, 3);
		hb:addHitbox(i, 72, 115, 38, 44, 2);
		hb:addHitbox(i, 72, 158, 58, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 68, 29, 52, 3);
		hb:addHitbox(i, 74, 121, 33, 40, 2);
		hb:addHitbox(i, 68, 157, 60, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 68, 31, 41, 3);
		hb:addHitbox(i, 67, 109, 43, 46, 2);
		hb:addHitbox(i, 69, 154, 63, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 64, 34, 50, 3);
		hb:addHitbox(i, 71, 114, 37, 49, 2);
		hb:addHitbox(i, 68, 160, 60, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 67, 35, 41, 3);
		hb:addHitbox(i, 70, 108, 38, 49, 2);
		hb:addHitbox(i, 66, 155, 64, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 73, 30, 49, 3);
		hb:addHitbox(i, 72, 122, 38, 41, 2);
		hb:addHitbox(i, 66, 162, 65, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 69, 33, 44, 3);
		hb:addHitbox(i, 73, 112, 36, 48, 2);
		hb:addHitbox(i, 67, 156, 60, 56, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 73, 31, 50, 3);
		hb:addHitbox(i, 77, 123, 30, 40, 2);
		hb:addHitbox(i, 65, 161, 66, 47, 1);

		return hb;
	end;
    
    getHitboxesForJumping = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 70, 69, 38, 50, 3);
		hb:addHitbox(i, 68, 118, 42, 50, 2);
		hb:addHitbox(i, 64, 165, 59, 43, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 72, 35, 44, 3);
		hb:addHitbox(i, 67, 112, 42, 47, 2);
		hb:addHitbox(i, 69, 155, 51, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 71, 72, 37, 49, 3);
		hb:addHitbox(i, 66, 122, 42, 41, 2);
		hb:addHitbox(i, 62, 162, 57, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 65, 34, 45, 3);
		hb:addHitbox(i, 66, 109, 44, 46, 2);
		hb:addHitbox(i, 60, 154, 65, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 56, 39, 53, 3);
		hb:addHitbox(i, 63, 108, 49, 52, 2);
		hb:addHitbox(i, 56, 159, 46, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 45, 33, 51, 3);
		hb:addHitbox(i, 66, 93, 37, 49, 2);
		hb:addHitbox(i, 53, 141, 53, 72, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 65, 36, 37, 45, 3);
		hb:addHitbox(i, 63, 78, 39, 66, 2);
		hb:addHitbox(i, 62, 143, 42, 69, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 65, 24, 35, 49, 3);
		hb:addHitbox(i, 62, 70, 39, 61, 2);
		hb:addHitbox(i, 60, 128, 48, 85, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 67, 24, 31, 55, 3);
		hb:addHitbox(i, 59, 77, 40, 64, 2);
		hb:addHitbox(i, 57, 137, 42, 77, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 24, 36, 57, 3);
		hb:addHitbox(i, 61, 83, 42, 50, 2);
		hb:addHitbox(i, 65, 130, 36, 84, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 26, 30, 51, 3);
		hb:addHitbox(i, 61, 78, 37, 74, 2);
		hb:addHitbox(i, 61, 150, 35, 63, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 33, 32, 49, 3);
		hb:addHitbox(i, 66, 82, 34, 51, 2);
		hb:addHitbox(i, 63, 131, 36, 81, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 44, 33, 50, 3);
		hb:addHitbox(i, 64, 94, 42, 66, 2);
		hb:addHitbox(i, 62, 160, 41, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 71, 50, 32, 48, 3);
		hb:addHitbox(i, 65, 98, 37, 59, 2);
		hb:addHitbox(i, 54, 156, 49, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 60, 30, 50, 3);
		hb:addHitbox(i, 67, 110, 36, 53, 2);
		hb:addHitbox(i, 60, 161, 42, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 73, 31, 53, 3);
		hb:addHitbox(i, 71, 125, 33, 33, 2);
		hb:addHitbox(i, 67, 158, 39, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 71, 34, 57, 3);
		hb:addHitbox(i, 67, 128, 43, 40, 2);
		hb:addHitbox(i, 64, 166, 63, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 75, 36, 48, 3);
		hb:addHitbox(i, 67, 123, 42, 42, 2);
		hb:addHitbox(i, 64, 164, 64, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 72, 28, 53, 3);
		hb:addHitbox(i, 71, 125, 37, 45, 2);
		hb:addHitbox(i, 65, 171, 65, 39, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 69, 29, 50, 3);
		hb:addHitbox(i, 69, 116, 41, 39, 2);
		hb:addHitbox(i, 69, 154, 53, 59, 1);

		return hb;
	end;
    
    getHitboxesForDefending = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 71, 80, 40, 37, 3);
		hb:addHitbox(i, 72, 116, 36, 54, 2);
		hb:addHitbox(i, 71, 170, 53, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 69, 31, 47, 3);
		hb:addHitbox(i, 68, 115, 40, 43, 2);
		hb:addHitbox(i, 65, 157, 58, 57, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 70, 33, 146, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 71, 69, 34, 145, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 67, 67, 38, 147, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 66, 65, 40, 142, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 61, 37, 154, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 66, 36, 143, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 68, 34, 144, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 63, 36, 148, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 66, 34, 145, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 66, 36, 141, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 66, 34, 148, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 65, 39, 142, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 66, 35, 142, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 63, 31, 148, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 65, 35, 146, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 69, 40, 147, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 66, 29, 51, 3);
		hb:addHitbox(i, 71, 116, 37, 41, 2);
		hb:addHitbox(i, 71, 157, 43, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 66, 32, 52, 3);
		hb:addHitbox(i, 72, 118, 33, 44, 2);
		hb:addHitbox(i, 72, 160, 44, 51, 1);

		return hb;
	end;    
	
    getHitboxesForDamage = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 59, 45, 54, 163, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 42, 46, 168, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 44, 53, 162, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 42, 55, 168, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 41, 55, 170, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 43, 54, 165, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 48, 50, 162, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 54, 48, 152, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 53, 49, 55, 157, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 54, 46, 153, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 55, 49, 151, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 52, 47, 153, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 49, 43, 157, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 64, 52, 39, 155, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 48, 45, 161, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 65, 51, 42, 160, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 44, 57, 161, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 44, 47, 162, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 45, 51, 162, 0);

		i = hb:createFrame();
		hb:addHitbox(i, 58, 41, 52, 171, 0);

		return hb;
	end;
    
    getHitboxesForLowPunch = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 70, 70, 41, 51, 3);
		hb:addHitbox(i, 68, 118, 40, 52, 2);
		hb:addHitbox(i, 59, 167, 66, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 67, 36, 53, 3);
		hb:addHitbox(i, 69, 119, 40, 40, 2);
		hb:addHitbox(i, 66, 158, 64, 51, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 47, 153, 22, 52, 4);
		hb:addHitbox(i, 72, 68, 34, 57, 3);
		hb:addHitbox(i, 71, 131, 38, 77, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 44, 143, 42, 57, 4);
		hb:addHitbox(i, 60, 108, 48, 35, 2);
		hb:addHitbox(i, 69, 67, 38, 44, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 147, 53, 51, 4);
		hb:addHitbox(i, 66, 69, 45, 41, 2);
		hb:addHitbox(i, 64, 108, 42, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 52, 142, 51, 50, 4);
		hb:addHitbox(i, 63, 68, 47, 40, 2);
		hb:addHitbox(i, 59, 107, 50, 38, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 142, 49, 50, 4);
		hb:addHitbox(i, 66, 68, 42, 37, 2);
		hb:addHitbox(i, 60, 105, 48, 39, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 140, 48, 46, 4);
		hb:addHitbox(i, 72, 70, 30, 39, 2);
		hb:addHitbox(i, 67, 105, 38, 37, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 145, 63, 32, 4);
		hb:addHitbox(i, 73, 71, 23, 68, 2);
		hb:addHitbox(i, 70, 179, 41, 29, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 134, 72, 38, 4);
		hb:addHitbox(i, 77, 75, 27, 61, 2);
		hb:addHitbox(i, 65, 179, 34, 34, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 139, 70, 36, 4);
		hb:addHitbox(i, 80, 70, 28, 68, 2);
		hb:addHitbox(i, 70, 172, 28, 33, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 130, 73, 43, 4);
		hb:addHitbox(i, 73, 72, 32, 60, 2);
		hb:addHitbox(i, 69, 173, 36, 37, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 67, 123, 75, 51, 4);
		hb:addHitbox(i, 78, 65, 29, 63, 2);
		hb:addHitbox(i, 68, 175, 36, 34, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 141, 64, 40, 4);
		hb:addHitbox(i, 77, 75, 23, 66, 2);
		hb:addHitbox(i, 66, 181, 37, 32, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 146, 57, 54, 4);
		hb:addHitbox(i, 77, 58, 19, 85, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 143, 38, 60, 4);
		hb:addHitbox(i, 81, 67, 19, 80, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 145, 22, 66, 4);
		hb:addHitbox(i, 73, 70, 36, 40, 2);
		hb:addHitbox(i, 73, 110, 30, 36, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 66, 31, 52, 3);
		hb:addHitbox(i, 73, 116, 29, 48, 2);
		hb:addHitbox(i, 69, 164, 42, 48, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 68, 32, 49, 3);
		hb:addHitbox(i, 71, 116, 33, 49, 2);
		hb:addHitbox(i, 66, 163, 56, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 66, 30, 50, 3);
		hb:addHitbox(i, 71, 112, 37, 49, 2);
		hb:addHitbox(i, 70, 157, 54, 53, 1);

		return hb;
	end;
    
    getHitboxesForHighPunch = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 69, 41, 44, 100, 3);
		hb:addHitbox(i, 71, 139, 35, 43, 2);
		hb:addHitbox(i, 57, 176, 41, 35, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 64, 33, 51, 3);
		hb:addHitbox(i, 67, 116, 43, 46, 2);
		hb:addHitbox(i, 62, 161, 58, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 144, 42, 69, 8);
		hb:addHitbox(i, 87, 75, 24, 69, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 159, 42, 49, 8);
		hb:addHitbox(i, 93, 81, 25, 78, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 150, 37, 62, 8);
		hb:addHitbox(i, 93, 82, 29, 69, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 146, 41, 65, 5);
		hb:addHitbox(i, 92, 86, 33, 60, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 150, 50, 57, 5);
		hb:addHitbox(i, 93, 81, 30, 69, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 81, 126, 51, 68, 5);
		hb:addHitbox(i, 90, 72, 23, 54, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 115, 69, 70, 5);
		hb:addHitbox(i, 77, 69, 27, 44, 3);
		hb:addHitbox(i, 48, 182, 73, 23, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 81, 123, 64, 47, 5);
		hb:addHitbox(i, 61, 64, 35, 58, 3);
		hb:addHitbox(i, 62, 163, 39, 42, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 105, 70, 64, 5);
		hb:addHitbox(i, 58, 65, 31, 39, 3);
		hb:addHitbox(i, 77, 166, 28, 40, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 110, 79, 61, 5);
		hb:addHitbox(i, 63, 71, 26, 39, 3);
		hb:addHitbox(i, 74, 168, 25, 38, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 115, 77, 58, 5);
		hb:addHitbox(i, 62, 69, 33, 46, 3);
		hb:addHitbox(i, 61, 170, 46, 37, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 71, 109, 79, 65, 5);
		hb:addHitbox(i, 61, 68, 36, 42, 3);
		hb:addHitbox(i, 62, 169, 45, 37, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 64, 121, 86, 71, 5);
		hb:addHitbox(i, 97, 120, 0, 0, 3);
		hb:addHitbox(i, 46, 189, 56, 15, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 131, 69, 68, 5);
		hb:addHitbox(i, 69, 68, 35, 62, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 146, 46, 67, 8);
		hb:addHitbox(i, 71, 70, 28, 69, 3);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 141, 48, 69, 8);
		hb:addHitbox(i, 72, 70, 32, 70, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 70, 35, 43, 3);
		hb:addHitbox(i, 71, 114, 37, 50, 2);
		hb:addHitbox(i, 66, 163, 56, 53, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 65, 33, 43, 3);
		hb:addHitbox(i, 67, 109, 43, 46, 2);
		hb:addHitbox(i, 72, 155, 53, 59, 1);

		return hb;
	end;
    
    getHitboxesForLowKick = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 77, 68, 29, 55, 3);
		hb:addHitbox(i, 73, 122, 37, 40, 2);
		hb:addHitbox(i, 73, 163, 50, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 80, 69, 27, 49, 3);
		hb:addHitbox(i, 71, 116, 38, 43, 2);
		hb:addHitbox(i, 69, 157, 56, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 72, 69, 34, 46, 3);
		hb:addHitbox(i, 68, 113, 42, 49, 2);
		hb:addHitbox(i, 67, 161, 49, 49, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 70, 33, 71, 2);
		hb:addHitbox(i, 67, 143, 47, 62, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 65, 28, 71, 2);
		hb:addHitbox(i, 75, 132, 41, 82, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 64, 27, 147, 8);

		i = hb:createFrame();
		hb:addHitbox(i, 73, 68, 34, 78, 2);
		hb:addHitbox(i, 73, 143, 35, 65, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 144, 57, 65, 6);
		hb:addHitbox(i, 63, 70, 47, 76, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 59, 140, 63, 62, 6);
		hb:addHitbox(i, 63, 69, 37, 71, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 63, 144, 70, 65, 6);
		hb:addHitbox(i, 65, 64, 20, 79, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 62, 145, 73, 62, 6);
		hb:addHitbox(i, 59, 66, 35, 80, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 147, 72, 62, 6);
		hb:addHitbox(i, 55, 68, 39, 77, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 61, 146, 72, 62, 6);
		hb:addHitbox(i, 60, 70, 33, 72, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 142, 71, 67, 6);
		hb:addHitbox(i, 65, 60, 24, 82, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 53, 144, 69, 61, 6);
		hb:addHitbox(i, 58, 72, 46, 71, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 49, 143, 62, 63, 6);
		hb:addHitbox(i, 55, 65, 52, 80, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 48, 145, 72, 60, 6);
		hb:addHitbox(i, 62, 68, 45, 76, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 43, 149, 83, 58, 6);
		hb:addHitbox(i, 54, 74, 59, 69, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 70, 70, 41, 53, 3);
		hb:addHitbox(i, 63, 124, 50, 43, 2);
		hb:addHitbox(i, 64, 160, 62, 46, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 75, 69, 30, 49, 3);
		hb:addHitbox(i, 71, 117, 36, 41, 2);
		hb:addHitbox(i, 67, 158, 60, 51, 1);

		return hb;
	end;
 
    getHitboxesForHighKick = function()
		LuaHitboxData = luajava.bindClass("core.scripts.lua.LuaHitboxData");
		hb = luajava.new(LuaHitboxData)

		i = hb:createFrame();
		hb:addHitbox(i, 73, 68, 36, 50, 3);
		hb:addHitbox(i, 73, 117, 37, 42, 2);
		hb:addHitbox(i, 67, 158, 51, 52, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 77, 61, 31, 46, 3);
		hb:addHitbox(i, 71, 107, 37, 47, 2);
		hb:addHitbox(i, 69, 153, 47, 47, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 40, 35, 56, 3);
		hb:addHitbox(i, 73, 91, 33, 44, 2);
		hb:addHitbox(i, 66, 133, 54, 50, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 48, 142, 46, 30, 7);
		hb:addHitbox(i, 76, 36, 26, 75, 2);
		hb:addHitbox(i, 75, 112, 39, 35, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 74, 38, 28, 104, 8);
		hb:addHitbox(i, 52, 139, 41, 48, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 34, 27, 111, 8);
		hb:addHitbox(i, 67, 145, 37, 45, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 56, 39, 36, 102, 8);
		hb:addHitbox(i, 65, 141, 38, 57, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 55, 33, 32, 122, 8);
		hb:addHitbox(i, 62, 152, 47, 54, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 66, 146, 67, 67, 7);
		hb:addHitbox(i, 60, 39, 29, 77, 3);
		hb:addHitbox(i, 58, 117, 38, 35, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 67, 138, 76, 37, 7);
		hb:addHitbox(i, 65, 37, 25, 58, 3);
		hb:addHitbox(i, 63, 93, 27, 44, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 135, 69, 37, 7);
		hb:addHitbox(i, 68, 41, 20, 64, 3);
		hb:addHitbox(i, 62, 105, 28, 30, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 149, 73, 49, 7);
		hb:addHitbox(i, 67, 36, 26, 72, 3);
		hb:addHitbox(i, 64, 107, 30, 42, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 68, 30, 23, 133, 8);
		hb:addHitbox(i, 69, 162, 38, 46, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 66, 45, 30, 128, 8);
		hb:addHitbox(i, 56, 172, 46, 25, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 69, 40, 25, 120, 8);
		hb:addHitbox(i, 60, 162, 43, 39, 7);

		i = hb:createFrame();
		hb:addHitbox(i, 57, 165, 41, 41, 8);
		hb:addHitbox(i, 68, 50, 31, 74, 3);
		hb:addHitbox(i, 67, 124, 40, 40, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 50, 168, 47, 40, 8);
		hb:addHitbox(i, 71, 53, 29, 61, 3);
		hb:addHitbox(i, 67, 117, 37, 54, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 52, 160, 46, 48, 8);
		hb:addHitbox(i, 69, 62, 36, 54, 3);
		hb:addHitbox(i, 66, 116, 40, 46, 2);

		i = hb:createFrame();
		hb:addHitbox(i, 76, 64, 28, 60, 3);
		hb:addHitbox(i, 68, 123, 37, 54, 2);
		hb:addHitbox(i, 52, 177, 55, 28, 1);

		i = hb:createFrame();
		hb:addHitbox(i, 78, 70, 25, 42, 3);
		hb:addHitbox(i, 70, 112, 34, 44, 2);
		hb:addHitbox(i, 60, 155, 56, 52, 1);

		return hb;
	end;
}