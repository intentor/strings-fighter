namespace HitboxCreator
{
    partial class frmManager
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmManager));
            this.picCurrentSprite = new System.Windows.Forms.PictureBox();
            this.gpbCommands = new System.Windows.Forms.GroupBox();
            this.txtHeight = new System.Windows.Forms.TextBox();
            this.txtCurrentFrame = new System.Windows.Forms.TextBox();
            this.txtFrameCount = new System.Windows.Forms.TextBox();
            this.txtWidth = new System.Windows.Forms.TextBox();
            this.lblX = new System.Windows.Forms.Label();
            this.lbloCurrentFrame = new System.Windows.Forms.Label();
            this.lblFrameCount = new System.Windows.Forms.Label();
            this.lblFrameSize = new System.Windows.Forms.Label();
            this.btnSaveHitboxes = new System.Windows.Forms.Button();
            this.btnLoadHitboxes = new System.Windows.Forms.Button();
            this.btnLoadSprite = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.rdbDefense = new System.Windows.Forms.RadioButton();
            this.rdbHighKick = new System.Windows.Forms.RadioButton();
            this.btnSaveCurrentHitBox = new System.Windows.Forms.Button();
            this.rdbLowKick = new System.Windows.Forms.RadioButton();
            this.rdbHighPunch = new System.Windows.Forms.RadioButton();
            this.rdbLowPunch = new System.Windows.Forms.RadioButton();
            this.rdpHit2 = new System.Windows.Forms.RadioButton();
            this.rdbHit15 = new System.Windows.Forms.RadioButton();
            this.rdbHit1 = new System.Windows.Forms.RadioButton();
            this.opfSprite = new System.Windows.Forms.OpenFileDialog();
            this.btnLastFrame = new System.Windows.Forms.Button();
            this.btnNextFrame = new System.Windows.Forms.Button();
            this.btnPreviousFrame = new System.Windows.Forms.Button();
            this.btnFirstFrame = new System.Windows.Forms.Button();
            this.statusBar = new System.Windows.Forms.StatusStrip();
            this.lblMousePosition = new System.Windows.Forms.ToolStripStatusLabel();
            this.lblInfo = new System.Windows.Forms.ToolStripStatusLabel();
            this.lstHitboxes = new System.Windows.Forms.ListBox();
            this.lblLstHitboxes = new System.Windows.Forms.Label();
            this.btnRemoveHitbox = new System.Windows.Forms.Button();
            this.opfLuaScript = new System.Windows.Forms.OpenFileDialog();
            this.txtLuaScript = new System.Windows.Forms.TextBox();
            this.lblScript = new System.Windows.Forms.Label();
            this.btnGetLuaScriptPath = new System.Windows.Forms.Button();
            this.rdbHit0 = new System.Windows.Forms.RadioButton();
            ((System.ComponentModel.ISupportInitialize)(this.picCurrentSprite)).BeginInit();
            this.gpbCommands.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.statusBar.SuspendLayout();
            this.SuspendLayout();
            // 
            // picCurrentSprite
            // 
            this.picCurrentSprite.BackColor = System.Drawing.Color.White;
            this.picCurrentSprite.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.picCurrentSprite.Location = new System.Drawing.Point(12, 41);
            this.picCurrentSprite.Name = "picCurrentSprite";
            this.picCurrentSprite.Size = new System.Drawing.Size(150, 220);
            this.picCurrentSprite.TabIndex = 0;
            this.picCurrentSprite.TabStop = false;
            this.picCurrentSprite.MouseMove += new System.Windows.Forms.MouseEventHandler(this.picCurrentSprite_MouseMove);
            this.picCurrentSprite.MouseDown += new System.Windows.Forms.MouseEventHandler(this.picCurrentSprite_MouseDown);
            // 
            // gpbCommands
            // 
            this.gpbCommands.Controls.Add(this.txtHeight);
            this.gpbCommands.Controls.Add(this.txtCurrentFrame);
            this.gpbCommands.Controls.Add(this.txtFrameCount);
            this.gpbCommands.Controls.Add(this.txtWidth);
            this.gpbCommands.Controls.Add(this.lblX);
            this.gpbCommands.Controls.Add(this.lbloCurrentFrame);
            this.gpbCommands.Controls.Add(this.lblFrameCount);
            this.gpbCommands.Controls.Add(this.lblFrameSize);
            this.gpbCommands.Controls.Add(this.btnSaveHitboxes);
            this.gpbCommands.Controls.Add(this.btnLoadHitboxes);
            this.gpbCommands.Controls.Add(this.btnLoadSprite);
            this.gpbCommands.Location = new System.Drawing.Point(346, 41);
            this.gpbCommands.Name = "gpbCommands";
            this.gpbCommands.Size = new System.Drawing.Size(176, 205);
            this.gpbCommands.TabIndex = 1;
            this.gpbCommands.TabStop = false;
            this.gpbCommands.Text = "Commands";
            // 
            // txtHeight
            // 
            this.txtHeight.Location = new System.Drawing.Point(126, 20);
            this.txtHeight.Name = "txtHeight";
            this.txtHeight.Size = new System.Drawing.Size(33, 20);
            this.txtHeight.TabIndex = 2;
            this.txtHeight.Text = "220";
            // 
            // txtCurrentFrame
            // 
            this.txtCurrentFrame.Location = new System.Drawing.Point(87, 75);
            this.txtCurrentFrame.Name = "txtCurrentFrame";
            this.txtCurrentFrame.ReadOnly = true;
            this.txtCurrentFrame.Size = new System.Drawing.Size(72, 20);
            this.txtCurrentFrame.TabIndex = 2;
            // 
            // txtFrameCount
            // 
            this.txtFrameCount.Location = new System.Drawing.Point(87, 49);
            this.txtFrameCount.Name = "txtFrameCount";
            this.txtFrameCount.ReadOnly = true;
            this.txtFrameCount.Size = new System.Drawing.Size(72, 20);
            this.txtFrameCount.TabIndex = 2;
            // 
            // txtWidth
            // 
            this.txtWidth.Location = new System.Drawing.Point(72, 20);
            this.txtWidth.Name = "txtWidth";
            this.txtWidth.Size = new System.Drawing.Size(33, 20);
            this.txtWidth.TabIndex = 2;
            this.txtWidth.Text = "150";
            // 
            // lblX
            // 
            this.lblX.AutoSize = true;
            this.lblX.Location = new System.Drawing.Point(110, 23);
            this.lblX.Name = "lblX";
            this.lblX.Size = new System.Drawing.Size(12, 13);
            this.lblX.TabIndex = 1;
            this.lblX.Text = "x";
            // 
            // lbloCurrentFrame
            // 
            this.lbloCurrentFrame.AutoSize = true;
            this.lbloCurrentFrame.Location = new System.Drawing.Point(12, 78);
            this.lbloCurrentFrame.Name = "lbloCurrentFrame";
            this.lbloCurrentFrame.Size = new System.Drawing.Size(73, 13);
            this.lbloCurrentFrame.TabIndex = 1;
            this.lbloCurrentFrame.Text = "Current frame:";
            // 
            // lblFrameCount
            // 
            this.lblFrameCount.AutoSize = true;
            this.lblFrameCount.Location = new System.Drawing.Point(12, 52);
            this.lblFrameCount.Name = "lblFrameCount";
            this.lblFrameCount.Size = new System.Drawing.Size(69, 13);
            this.lblFrameCount.TabIndex = 1;
            this.lblFrameCount.Text = "Frame count:";
            // 
            // lblFrameSize
            // 
            this.lblFrameSize.AutoSize = true;
            this.lblFrameSize.Location = new System.Drawing.Point(10, 25);
            this.lblFrameSize.Name = "lblFrameSize";
            this.lblFrameSize.Size = new System.Drawing.Size(57, 13);
            this.lblFrameSize.TabIndex = 1;
            this.lblFrameSize.Text = "Frame size";
            // 
            // btnSaveHitboxes
            // 
            this.btnSaveHitboxes.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSaveHitboxes.Location = new System.Drawing.Point(15, 167);
            this.btnSaveHitboxes.Name = "btnSaveHitboxes";
            this.btnSaveHitboxes.Size = new System.Drawing.Size(144, 23);
            this.btnSaveHitboxes.TabIndex = 0;
            this.btnSaveHitboxes.Text = "Save hitboxes";
            this.btnSaveHitboxes.UseVisualStyleBackColor = true;
            this.btnSaveHitboxes.Click += new System.EventHandler(this.btnSaveHitboxes_Click);
            // 
            // btnLoadHitboxes
            // 
            this.btnLoadHitboxes.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLoadHitboxes.Location = new System.Drawing.Point(15, 136);
            this.btnLoadHitboxes.Name = "btnLoadHitboxes";
            this.btnLoadHitboxes.Size = new System.Drawing.Size(144, 23);
            this.btnLoadHitboxes.TabIndex = 0;
            this.btnLoadHitboxes.Text = "Load hitboxes";
            this.btnLoadHitboxes.UseVisualStyleBackColor = true;
            this.btnLoadHitboxes.Click += new System.EventHandler(this.btnLoadHitboxes_Click);
            // 
            // btnLoadSprite
            // 
            this.btnLoadSprite.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLoadSprite.Location = new System.Drawing.Point(15, 105);
            this.btnLoadSprite.Name = "btnLoadSprite";
            this.btnLoadSprite.Size = new System.Drawing.Size(144, 23);
            this.btnLoadSprite.TabIndex = 0;
            this.btnLoadSprite.Text = "Load sprite";
            this.btnLoadSprite.UseVisualStyleBackColor = true;
            this.btnLoadSprite.Click += new System.EventHandler(this.btnLoadSprite_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.rdbDefense);
            this.groupBox2.Controls.Add(this.rdbHighKick);
            this.groupBox2.Controls.Add(this.btnSaveCurrentHitBox);
            this.groupBox2.Controls.Add(this.rdbLowKick);
            this.groupBox2.Controls.Add(this.rdbHighPunch);
            this.groupBox2.Controls.Add(this.rdbLowPunch);
            this.groupBox2.Controls.Add(this.rdpHit2);
            this.groupBox2.Controls.Add(this.rdbHit15);
            this.groupBox2.Controls.Add(this.rdbHit0);
            this.groupBox2.Controls.Add(this.rdbHit1);
            this.groupBox2.Location = new System.Drawing.Point(191, 41);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(143, 260);
            this.groupBox2.TabIndex = 3;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Hitbox type";
            // 
            // rdbDefense
            // 
            this.rdbDefense.AutoSize = true;
            this.rdbDefense.Location = new System.Drawing.Point(11, 203);
            this.rdbDefense.Name = "rdbDefense";
            this.rdbDefense.Size = new System.Drawing.Size(65, 17);
            this.rdbDefense.TabIndex = 0;
            this.rdbDefense.Text = "Defense";
            this.rdbDefense.UseVisualStyleBackColor = true;
            this.rdbDefense.CheckedChanged += new System.EventHandler(this.rdbDefense_CheckedChanged);
            // 
            // rdbHighKick
            // 
            this.rdbHighKick.AutoSize = true;
            this.rdbHighKick.Location = new System.Drawing.Point(11, 180);
            this.rdbHighKick.Name = "rdbHighKick";
            this.rdbHighKick.Size = new System.Drawing.Size(70, 17);
            this.rdbHighKick.TabIndex = 0;
            this.rdbHighKick.Text = "High kick";
            this.rdbHighKick.UseVisualStyleBackColor = true;
            this.rdbHighKick.CheckedChanged += new System.EventHandler(this.rdbHighKick_CheckedChanged);
            // 
            // btnSaveCurrentHitBox
            // 
            this.btnSaveCurrentHitBox.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSaveCurrentHitBox.Location = new System.Drawing.Point(9, 226);
            this.btnSaveCurrentHitBox.Name = "btnSaveCurrentHitBox";
            this.btnSaveCurrentHitBox.Size = new System.Drawing.Size(126, 23);
            this.btnSaveCurrentHitBox.TabIndex = 1;
            this.btnSaveCurrentHitBox.Text = "Save";
            this.btnSaveCurrentHitBox.UseVisualStyleBackColor = true;
            this.btnSaveCurrentHitBox.Click += new System.EventHandler(this.btnSaveCurrentHitBox_Click);
            // 
            // rdbLowKick
            // 
            this.rdbLowKick.AutoSize = true;
            this.rdbLowKick.Location = new System.Drawing.Point(11, 157);
            this.rdbLowKick.Name = "rdbLowKick";
            this.rdbLowKick.Size = new System.Drawing.Size(68, 17);
            this.rdbLowKick.TabIndex = 0;
            this.rdbLowKick.Text = "Low kick";
            this.rdbLowKick.UseVisualStyleBackColor = true;
            this.rdbLowKick.CheckedChanged += new System.EventHandler(this.rdbLowKick_CheckedChanged);
            // 
            // rdbHighPunch
            // 
            this.rdbHighPunch.AutoSize = true;
            this.rdbHighPunch.Location = new System.Drawing.Point(11, 134);
            this.rdbHighPunch.Name = "rdbHighPunch";
            this.rdbHighPunch.Size = new System.Drawing.Size(80, 17);
            this.rdbHighPunch.TabIndex = 0;
            this.rdbHighPunch.Text = "High punch";
            this.rdbHighPunch.UseVisualStyleBackColor = true;
            this.rdbHighPunch.CheckedChanged += new System.EventHandler(this.rdbHighPunch_CheckedChanged);
            // 
            // rdbLowPunch
            // 
            this.rdbLowPunch.AutoSize = true;
            this.rdbLowPunch.Location = new System.Drawing.Point(11, 111);
            this.rdbLowPunch.Name = "rdbLowPunch";
            this.rdbLowPunch.Size = new System.Drawing.Size(78, 17);
            this.rdbLowPunch.TabIndex = 0;
            this.rdbLowPunch.Text = "Low punch";
            this.rdbLowPunch.UseVisualStyleBackColor = true;
            this.rdbLowPunch.CheckedChanged += new System.EventHandler(this.rdbLowPunch_CheckedChanged);
            // 
            // rdpHit2
            // 
            this.rdpHit2.AutoSize = true;
            this.rdpHit2.Location = new System.Drawing.Point(11, 88);
            this.rdpHit2.Name = "rdpHit2";
            this.rdpHit2.Size = new System.Drawing.Size(52, 17);
            this.rdpHit2.TabIndex = 0;
            this.rdpHit2.Text = "Hit x2";
            this.rdpHit2.UseVisualStyleBackColor = true;
            this.rdpHit2.CheckedChanged += new System.EventHandler(this.rdpHit2_CheckedChanged);
            // 
            // rdbHit15
            // 
            this.rdbHit15.AutoSize = true;
            this.rdbHit15.Location = new System.Drawing.Point(11, 65);
            this.rdbHit15.Name = "rdbHit15";
            this.rdbHit15.Size = new System.Drawing.Size(61, 17);
            this.rdbHit15.TabIndex = 0;
            this.rdbHit15.Text = "Hit x1.5";
            this.rdbHit15.UseVisualStyleBackColor = true;
            this.rdbHit15.CheckedChanged += new System.EventHandler(this.rdbHit15_CheckedChanged);
            // 
            // rdbHit1
            // 
            this.rdbHit1.AutoSize = true;
            this.rdbHit1.Checked = true;
            this.rdbHit1.Location = new System.Drawing.Point(11, 42);
            this.rdbHit1.Name = "rdbHit1";
            this.rdbHit1.Size = new System.Drawing.Size(52, 17);
            this.rdbHit1.TabIndex = 0;
            this.rdbHit1.TabStop = true;
            this.rdbHit1.Text = "Hit x1";
            this.rdbHit1.UseVisualStyleBackColor = true;
            this.rdbHit1.CheckedChanged += new System.EventHandler(this.rdbHit1_CheckedChanged);
            // 
            // opfSprite
            // 
            this.opfSprite.Filter = "PNG Sprites|*.png";
            this.opfSprite.Title = "Please select the sprite to be loaded";
            // 
            // btnLastFrame
            // 
            this.btnLastFrame.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLastFrame.Location = new System.Drawing.Point(126, 12);
            this.btnLastFrame.Name = "btnLastFrame";
            this.btnLastFrame.Size = new System.Drawing.Size(30, 23);
            this.btnLastFrame.TabIndex = 2;
            this.btnLastFrame.Text = ">>";
            this.btnLastFrame.UseVisualStyleBackColor = true;
            this.btnLastFrame.Click += new System.EventHandler(this.btnLastFrame_Click);
            // 
            // btnNextFrame
            // 
            this.btnNextFrame.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnNextFrame.Location = new System.Drawing.Point(90, 12);
            this.btnNextFrame.Name = "btnNextFrame";
            this.btnNextFrame.Size = new System.Drawing.Size(30, 23);
            this.btnNextFrame.TabIndex = 2;
            this.btnNextFrame.Text = ">";
            this.btnNextFrame.UseVisualStyleBackColor = true;
            this.btnNextFrame.Click += new System.EventHandler(this.btnNextFrame_Click);
            // 
            // btnPreviousFrame
            // 
            this.btnPreviousFrame.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnPreviousFrame.Location = new System.Drawing.Point(54, 12);
            this.btnPreviousFrame.Name = "btnPreviousFrame";
            this.btnPreviousFrame.Size = new System.Drawing.Size(30, 23);
            this.btnPreviousFrame.TabIndex = 2;
            this.btnPreviousFrame.Text = "<";
            this.btnPreviousFrame.UseVisualStyleBackColor = true;
            this.btnPreviousFrame.Click += new System.EventHandler(this.btnPreviousFrame_Click);
            // 
            // btnFirstFrame
            // 
            this.btnFirstFrame.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFirstFrame.Location = new System.Drawing.Point(18, 12);
            this.btnFirstFrame.Name = "btnFirstFrame";
            this.btnFirstFrame.Size = new System.Drawing.Size(30, 23);
            this.btnFirstFrame.TabIndex = 2;
            this.btnFirstFrame.Text = "<<";
            this.btnFirstFrame.UseVisualStyleBackColor = true;
            this.btnFirstFrame.Click += new System.EventHandler(this.btnFirstFrame_Click);
            // 
            // statusBar
            // 
            this.statusBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.lblMousePosition,
            this.lblInfo});
            this.statusBar.Location = new System.Drawing.Point(0, 457);
            this.statusBar.Name = "statusBar";
            this.statusBar.Size = new System.Drawing.Size(537, 22);
            this.statusBar.TabIndex = 3;
            this.statusBar.Text = "statusBar";
            // 
            // lblMousePosition
            // 
            this.lblMousePosition.Name = "lblMousePosition";
            this.lblMousePosition.Size = new System.Drawing.Size(0, 17);
            // 
            // lblInfo
            // 
            this.lblInfo.Name = "lblInfo";
            this.lblInfo.Size = new System.Drawing.Size(84, 17);
            this.lblInfo.Text = "Hitbox Creator";
            // 
            // lstHitboxes
            // 
            this.lstHitboxes.FormattingEnabled = true;
            this.lstHitboxes.Location = new System.Drawing.Point(183, 323);
            this.lstHitboxes.Name = "lstHitboxes";
            this.lstHitboxes.Size = new System.Drawing.Size(339, 95);
            this.lstHitboxes.TabIndex = 4;
            this.lstHitboxes.SelectedIndexChanged += new System.EventHandler(this.lstHitboxes_SelectedIndexChanged);
            // 
            // lblLstHitboxes
            // 
            this.lblLstHitboxes.AutoSize = true;
            this.lblLstHitboxes.Location = new System.Drawing.Point(180, 307);
            this.lblLstHitboxes.Name = "lblLstHitboxes";
            this.lblLstHitboxes.Size = new System.Drawing.Size(112, 13);
            this.lblLstHitboxes.TabIndex = 1;
            this.lblLstHitboxes.Text = "Current frame hitboxes";
            // 
            // btnRemoveHitbox
            // 
            this.btnRemoveHitbox.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnRemoveHitbox.Location = new System.Drawing.Point(492, 424);
            this.btnRemoveHitbox.Name = "btnRemoveHitbox";
            this.btnRemoveHitbox.Size = new System.Drawing.Size(30, 23);
            this.btnRemoveHitbox.TabIndex = 2;
            this.btnRemoveHitbox.Text = "-";
            this.btnRemoveHitbox.UseVisualStyleBackColor = true;
            this.btnRemoveHitbox.Click += new System.EventHandler(this.btnRemoveHitbox_Click);
            // 
            // opfLuaScript
            // 
            this.opfLuaScript.Filter = "Lua scripts|*.lua";
            this.opfLuaScript.Title = "Please select the Lua Script with hitboxes data";
            // 
            // txtLuaScript
            // 
            this.txtLuaScript.Location = new System.Drawing.Point(250, 12);
            this.txtLuaScript.Name = "txtLuaScript";
            this.txtLuaScript.ReadOnly = true;
            this.txtLuaScript.Size = new System.Drawing.Size(234, 20);
            this.txtLuaScript.TabIndex = 5;
            // 
            // lblScript
            // 
            this.lblScript.AutoSize = true;
            this.lblScript.Location = new System.Drawing.Point(188, 17);
            this.lblScript.Name = "lblScript";
            this.lblScript.Size = new System.Drawing.Size(56, 13);
            this.lblScript.TabIndex = 6;
            this.lblScript.Text = "Lua script:";
            // 
            // btnGetLuaScriptPath
            // 
            this.btnGetLuaScriptPath.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnGetLuaScriptPath.Location = new System.Drawing.Point(492, 10);
            this.btnGetLuaScriptPath.Name = "btnGetLuaScriptPath";
            this.btnGetLuaScriptPath.Size = new System.Drawing.Size(30, 23);
            this.btnGetLuaScriptPath.TabIndex = 2;
            this.btnGetLuaScriptPath.Text = "+";
            this.btnGetLuaScriptPath.UseVisualStyleBackColor = true;
            this.btnGetLuaScriptPath.Click += new System.EventHandler(this.btnGetLuaScriptPath_Click);
            // 
            // rdbHit0
            // 
            this.rdbHit0.AutoSize = true;
            this.rdbHit0.Location = new System.Drawing.Point(11, 19);
            this.rdbHit0.Name = "rdbHit0";
            this.rdbHit0.Size = new System.Drawing.Size(52, 17);
            this.rdbHit0.TabIndex = 0;
            this.rdbHit0.Text = "Hit x0";
            this.rdbHit0.UseVisualStyleBackColor = true;
            this.rdbHit0.CheckedChanged += new System.EventHandler(this.rdbHit0_CheckedChanged);
            // 
            // frmManager
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(537, 479);
            this.Controls.Add(this.lblScript);
            this.Controls.Add(this.txtLuaScript);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.lstHitboxes);
            this.Controls.Add(this.statusBar);
            this.Controls.Add(this.btnFirstFrame);
            this.Controls.Add(this.lblLstHitboxes);
            this.Controls.Add(this.btnPreviousFrame);
            this.Controls.Add(this.btnGetLuaScriptPath);
            this.Controls.Add(this.btnRemoveHitbox);
            this.Controls.Add(this.btnNextFrame);
            this.Controls.Add(this.btnLastFrame);
            this.Controls.Add(this.gpbCommands);
            this.Controls.Add(this.picCurrentSprite);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmManager";
            this.Text = "Strings Fighter - Hitbox Creator";
            this.Load += new System.EventHandler(this.frmManager_Load);
            ((System.ComponentModel.ISupportInitialize)(this.picCurrentSprite)).EndInit();
            this.gpbCommands.ResumeLayout(false);
            this.gpbCommands.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.statusBar.ResumeLayout(false);
            this.statusBar.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox picCurrentSprite;
        private System.Windows.Forms.GroupBox gpbCommands;
        private System.Windows.Forms.Button btnLoadSprite;
        private System.Windows.Forms.TextBox txtHeight;
        private System.Windows.Forms.TextBox txtWidth;
        private System.Windows.Forms.Label lblX;
        private System.Windows.Forms.Label lblFrameSize;
        private System.Windows.Forms.TextBox txtFrameCount;
        private System.Windows.Forms.Label lblFrameCount;
        private System.Windows.Forms.OpenFileDialog opfSprite;
        private System.Windows.Forms.Button btnLastFrame;
        private System.Windows.Forms.Button btnNextFrame;
        private System.Windows.Forms.Button btnPreviousFrame;
        private System.Windows.Forms.Button btnFirstFrame;
        private System.Windows.Forms.TextBox txtCurrentFrame;
        private System.Windows.Forms.Label lbloCurrentFrame;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton rdbLowKick;
        private System.Windows.Forms.RadioButton rdbLowPunch;
        private System.Windows.Forms.RadioButton rdpHit2;
        private System.Windows.Forms.RadioButton rdbHit15;
        private System.Windows.Forms.RadioButton rdbHit1;
        private System.Windows.Forms.StatusStrip statusBar;
        private System.Windows.Forms.ToolStripStatusLabel lblMousePosition;
        private System.Windows.Forms.Button btnSaveCurrentHitBox;
        private System.Windows.Forms.Button btnSaveHitboxes;
        private System.Windows.Forms.Button btnLoadHitboxes;
        private System.Windows.Forms.RadioButton rdbHighKick;
        private System.Windows.Forms.RadioButton rdbHighPunch;
        private System.Windows.Forms.RadioButton rdbDefense;
        private System.Windows.Forms.ListBox lstHitboxes;
        private System.Windows.Forms.Label lblLstHitboxes;
        private System.Windows.Forms.Button btnRemoveHitbox;
        private System.Windows.Forms.OpenFileDialog opfLuaScript;
        private System.Windows.Forms.ToolStripStatusLabel lblInfo;
        private System.Windows.Forms.TextBox txtLuaScript;
        private System.Windows.Forms.Label lblScript;
        private System.Windows.Forms.Button btnGetLuaScriptPath;
        private System.Windows.Forms.RadioButton rdbHit0;
    }
}

